package com.example.coffeeMachine;
public class CustomerOrder {
    private DrinkTypeEnum drinkType;
    private int numberOfSugar = 0;
    private Double givenMoney;
    private Boolean isExtraHotDrink;

    public CustomerOrder(DrinkTypeEnum drinkType, int numberOfSugar, Double givenMoney, Boolean extraHotDrink) {
        this.drinkType = drinkType;
        this.numberOfSugar = numberOfSugar;
        this.givenMoney = givenMoney;
        this.isExtraHotDrink = extraHotDrink;
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

    public Boolean getIsExtraHotDrink() {
        return isExtraHotDrink;
    }
}