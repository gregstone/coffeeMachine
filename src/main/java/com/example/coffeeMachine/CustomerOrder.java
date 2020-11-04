package com.example.coffeeMachine;
public class CustomerOrder {
    private DrinkTypeEnum drinkType;
    private int numberOfSugar = 0;

    public CustomerOrder(DrinkTypeEnum drinkType, int numberOfSugar) {
        this.drinkType = drinkType;
        this.numberOfSugar = numberOfSugar;
    }

    public DrinkTypeEnum getDrinkType() {
        return drinkType;
    }

    public int getNumberOfSugar() {
        return numberOfSugar;
    }
}