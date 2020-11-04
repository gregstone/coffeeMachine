package com.example.coffeeMachine;

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
}
