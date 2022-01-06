package br.ufma.lsdi.cddedesktopdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.zkoss.bind.annotation.ContextParam;
//import org.zkoss.bind.annotation.ContextType;
//import org.zkoss.zk.ui.Component;
//import org.zkoss.zk.ui.select.Selectors;
//import org.zkoss.bind.annotation.Init;
//import org.zkoss.bind.annotation.AfterCompose;
//import org.zkoss.bind.annotation.NotifyChange;
//import org.zkoss.bind.annotation.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@Service
public class HelloView {

//    private List<Temperature> localTemperatures = new ArrayList<>();
//    private List<Temperature> remoteTemperatures = new ArrayList<>();
//
//    private InterSCityService service = InterSCityService.getInstance();
//
//    ObjectMapper mapper = new ObjectMapper();
//
//    @Init
//    public void init() {
//        EventBus.getDefault().register(this);
//
//        new Thread(() -> {
//            while(true) {
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                ArrayList<SensorData> list = service.getSensorData("da305579-9f8c-4c87-93bd-186638b86581", "temperatureABC");
//                List<Temperature> temps = list.stream().map(elem -> mapper.convertValue(elem.getValue(), Temperature.class)).collect(Collectors.toList());
//                remoteTemperatures.addAll(temps);
//            }
//        }).start();
//    }
//
//    @AfterCompose
//    public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
//        Selectors.wireComponents(view, this, false);
//    }
//
//    @Command
//    @NotifyChange("localTemperatures")
//    public void ok() {
//        localTemperatures = localTemperatures;
//    }
//
//    @Subscribe
//    public void on(NewLocalTemperature event) {
//        localTemperatures.add(event.getTemperature());
//    }
//
//    @Subscribe
//    public void on(NewRemoteTemperature event) {
//        remoteTemperatures.add(event.getTemperature());
//    }

}
