package br.ufma.lsdi.cddedesktopdemo;

import java.io.Serializable;

public class Temperature implements Serializable {
    private Double value;
    private String date;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
