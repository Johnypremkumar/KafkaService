package org.kafka.KakfaService.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Payload {

    @JsonProperty("name")
    private String name;

    @JsonProperty("city")
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
