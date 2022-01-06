package br.ufma.lsdi.cddedesktopdemo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Capability {
    private String name;
    private String description;
    @JsonProperty("capability_type")
    private String capabilityType;
}
