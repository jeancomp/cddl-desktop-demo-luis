package br.ufma.lsdi.cddedesktopdemo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor
@NoArgsConstructor
public class Resource {
    private Integer id;
    private String uuid;
    private String description;
    private String uri;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    private Double lat;
    private Double lon;
    private String status;
    @JsonProperty("collect_interval")
    private Integer collectInterval;
    private String city;
    private String neighborhood;
    private String state;
    @JsonProperty("postal_code")
    private String postalCode;
    private String country;
    private String[] capabilities;
}
