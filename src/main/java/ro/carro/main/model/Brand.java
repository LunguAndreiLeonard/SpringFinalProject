package ro.carro.main.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Brand {
    @JsonProperty("vw") VW,
    @JsonProperty("bmw") BMW,
    @JsonProperty("audi") AUDI,
    @JsonProperty("skoda") SKODA,
    @JsonProperty("mercedes") MERCEDES
}
