package com.example.coffeeMachine;
public class CustomerOrder {
    private DrinkTypeEnum drinkType;
    private int numberOfSugar = 0;
    private Double givenMoney;

    public CustomerOrder(DrinkTypeEnum drinkType, int numberOfSugar, Double givenMoney) {
        this.drinkType = drinkType;
        this.numberOfSugar = numberOfSugar;
        this.givenMoney = givenMoney;
    }

    public DrinkTypeEnum getDrinkType() {
        return drinkType;
    }

    public int getNumberOfSugar() {
        return numberOfSugar;
    }

    public Double getGivenMoney() {
        return givenMoney;
    }
}