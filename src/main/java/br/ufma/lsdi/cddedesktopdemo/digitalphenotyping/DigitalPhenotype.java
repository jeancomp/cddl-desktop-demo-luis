package br.ufma.lsdi.cddedesktopdemo.digitalphenotyping;

import java.util.ArrayList;
import java.util.List;

public class DigitalPhenotype {
    public List<DigitalPhenotypeEvent> dpeList = new ArrayList();

    public DigitalPhenotype(){}

    public List<DigitalPhenotypeEvent> getDigitalPhenotypeEventList(){
        return dpeList;
    }

    public void setDpeList(DigitalPhenotypeEvent digitalPhenotypeEvent){
        dpeList.add(digitalPhenotypeEvent);
    }

    public void print(DigitalPhenotypeEvent digitalPhenotypeEvent){
        System.out.println("DigitalPhenotype");
        System.out.println("DataProcessorName: " + digitalPhenotypeEvent.getDataProcessorName());
        System.out.println("Uid: " + digitalPhenotypeEvent.getUid());

        System.out.println("Attributes");
        for(int i=0; i < digitalPhenotypeEvent.getAttributes().size(); i++) {
            System.out.println("Label: " + digitalPhenotypeEvent.getAttributes().get(i).getLabel());
            System.out.println("Value: " + digitalPhenotypeEvent.getAttributes().get(i).getValue());
            System.out.println("Type: " + digitalPhenotypeEvent.getAttributes().get(i).getType());
            System.out.println("QualityAttribute: " + digitalPhenotypeEvent.getAttributes().get(i).isQualityAttribute());
        }

        System.out.println("Situation");
        System.out.println("Label: " + digitalPhenotypeEvent.getSituation().getLabel());
        System.out.println("Description: " + digitalPhenotypeEvent.getSituation().getDescription());
    }
}