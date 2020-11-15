package com.example.coffeeMachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum DrinkTypeEnum {
    COFFEE("C", 0.6),
    TEA("T", 0.4),
    CHOCOLATE("H", 0.5),
    ORANGE_JUICE("O", 0.6);

    private String code;
    private Double price;

    DrinkTypeEnum(String code, Double price) {
        this.code = code;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public Double getPrice() {
        return price;
    }

    private List<DrinkTypeEnum> nonHeatableDrink() {
        return Collections.singletonList(DrinkTypeEnum.ORANGE_JUICE);
    }

    public boolean isHeatableDrink() {
        return !nonHeatableDrink().contains(this);
    }
}
