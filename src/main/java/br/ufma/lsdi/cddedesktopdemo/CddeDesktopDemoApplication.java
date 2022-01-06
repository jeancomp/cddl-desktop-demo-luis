package br.ufma.lsdi.cddedesktopdemo;

import br.ufma.lsdi.cddedesktopdemo.digitalphenotyping.DigitalPhenotype;
import br.ufma.lsdi.cddedesktopdemo.digitalphenotyping.DigitalPhenotypeEvent;
import br.ufma.lsdi.cddl.CDDL;
import br.ufma.lsdi.cddl.Connection;
import br.ufma.lsdi.cddl.ConnectionFactory;
import br.ufma.lsdi.cddl.pubsub.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CddeDesktopDemoApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(CddeDesktopDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Connection con = ConnectionFactory.createConnection();
        con.setClientId("jeancomp");
        con.setHost("192.168.0.7");
        con.connect();

        CDDL cddl = CDDL.getInstance();
        cddl.setConnection(con);
        cddl.startService();

        Subscriber subRawDataCollector = SubscriberFactory.createSubscriber();
        subRawDataCollector.addConnection(con);
        subRawDataCollector.subscribeTopic("rawdatacollector");
        subRawDataCollector.subscribeServiceByName("rawdatacollector");
        subRawDataCollector.setSubscriberListener(message -> System.out.println("-------------------------" + message));

        Subscriber subDigitalPhenotypingEvent = SubscriberFactory.createSubscriber();
        subDigitalPhenotypingEvent.addConnection(con);
        subDigitalPhenotypingEvent.subscribeTopic("opendpmh");
        subDigitalPhenotypingEvent.subscribeServiceByName("opendpmh");
        subDigitalPhenotypingEvent.setSubscriberListener(message -> System.out.println("+++++++++++++++++++++++" + message));

        subDigitalPhenotypingEvent.getMonitor().addRule("select * from Message", message -> {
            System.out.println("MONITORAMENTO");

            Object[] valor = message.getServiceValue();
            String mensagemRecebida = StringUtils.join(valor, ", ");

            DigitalPhenotype digitalPhenotype = new DigitalPhenotype();
            digitalPhenotype = jsonToPhenotype(mensagemRecebida);

            for(int i=0; i < digitalPhenotype.getDigitalPhenotypeEventList().size(); i++) {
                digitalPhenotype.print(digitalPhenotype.getDigitalPhenotypeEventList().get(i));
            }
        });
    }

    public DigitalPhenotype jsonToPhenotype(String jsonString){
        Type listType = new TypeToken<DigitalPhenotype>(){}.getType();
        DigitalPhenotype dp = new Gson().fromJson(jsonString, listType);
        return dp;
    }
}
