package br.ufma.lsdi.cddedesktopdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorData {
    private Object value;
    private String date;
}
