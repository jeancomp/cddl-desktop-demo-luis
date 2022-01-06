package br.ufma.lsdi.cddedesktopdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

public class InterSCityService {

    private final RestTemplate rest = new RestTemplate();
    private final ObjectMapper mapper = new ObjectMapper();

    private final String INTERSCITY_URL = "http://api.playground.interscity.org";

    private static InterSCityService instance;

    private InterSCityService() {}

    public static InterSCityService getInstance() {
        if (instance == null) {
            instance = new InterSCityService();
        }
        return instance;
    }

    public Capability getCapability(String name) {
        return rest.getForObject(INTERSCITY_URL + "/catalog/capabilities/" + name, Capability.class);
    }
    public Capability publishCapability(Capability capability) {
        return rest.postForObject(INTERSCITY_URL + "/catalog/capabilities", capability, Capability.class);
    }

    public Resource getResource(String uuid) {
        val resp = rest.getForObject(INTERSCITY_URL + "/catalog/resources/" + uuid, Map.class);
        return mapper.convertValue(resp.get("data"), Resource.class);
    }
    public Resource publishResource(Resource resource) {
        val data = new HashMap<>();
        data.put("data", resource);
        val resp = rest.postForObject(INTERSCITY_URL + "/catalog/resources", data, Map.class);
        return mapper.convertValue(resp.get("data"), Resource.class);
    }


    public ArrayList<SensorData> getSensorData(String uuid, String capability) {
        val capabilities = new String[] {capability};
        val body = new HashMap<>();
        body.put("capabilities", capabilities);
        val resp = rest.postForObject(INTERSCITY_URL  + "/collector/resources/" + uuid + "/data", body, Map.class);
        val resources = (ArrayList) resp.get("resources");
        val resource = (Map) resources.get(0);
        val caps = (Map) resource.get("capabilities");
        val temps = (ArrayList) caps.get(capability);
        val list = (ArrayList<SensorData>) temps.stream().map(temp -> mapper.convertValue(temp, SensorData.class)).collect(Collectors.toList());
        return list;
    }
    public ArrayList<SensorData> getLastSensorData(String uuid, String capability) {
        val capabilities = new String[] {capability};
        val body = new HashMap<>();
        body.put("capabilities", capabilities);
        val resp = rest.postForObject(INTERSCITY_URL  + "/collector/resources/" + uuid + "/data/last", body, Map.class);
        val resources = (ArrayList) resp.get("resources");
        val resource = (Map) resources.get(0);
        val caps = (Map) resource.get("capabilities");
        val temps = (ArrayList) caps.get(capability);
        val list = (ArrayList<SensorData>) temps.stream().map(temp -> mapper.convertValue(temp, SensorData.class)).collect(Collectors.toList());
        return list;
    }
    public void publishSensorData(String uuid, String capability, SensorData sensorData) {
        val datas = new ArrayList<>();
        datas.add(sensorData);
        val data = new HashMap<>();
        data.put("data", datas);
        rest.postForObject(INTERSCITY_URL + "/adaptor/resources/" + uuid + "/data/" + capability, data, Map.class);
    }

}
