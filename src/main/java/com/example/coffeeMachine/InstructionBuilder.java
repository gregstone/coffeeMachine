package com.example.coffeeMachine;

public class InstructionBuilder {

    private DrinkMaker drinkMaker;

    public InstructionBuilder(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public String buildBeverageInstructionForDrinkMaker(CustomerOrder customerOrder) {

        String drinkInstruction = customerOrder.getDrinkType().getCode();
        String sugarInstruction = buildSugarInstruction(customerOrder.getNumberOfSugar());

        String beverageInstruction = drinkInstruction + sugarInstruction;

        drinkMaker.makeDrink(beverageInstruction);

        return beverageInstruction;

    }

    private String buildSugarInstruction(Integer numberOfSugar) {
        boolean isCustomerWantSugar = numberOfSugar > 0;
        String addSugarAndStick = ":".concat(numberOfSugar.toString()).concat(":0");;
        String withoutSugarAndStick = "::";

        return isCustomerWantSugar ? addSugarAndStick : withoutSugarAndStick;
    }
}