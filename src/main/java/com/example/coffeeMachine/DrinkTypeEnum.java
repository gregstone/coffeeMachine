package com.example.coffeeMachine;

public enum DrinkTypeEnum {
    COFFEE("C"),
    TEA("T"),
    CHOCOLATE("H");

    private String code;

    DrinkTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
