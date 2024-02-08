package pl.micede.spring_rest_app.model;

import lombok.Getter;

@Getter
public enum FuelType {
    GAS("gas"),
    DIESEL("diesel"),
    ELECTRIC("electric"),
    LPG("lpg")
    ;

    private final String name;

    FuelType(String name) {
        this.name = name;
    }
}
