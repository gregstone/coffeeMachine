package com.example.coffeeMachine;

public class InstructionBuilder {

    private DrinkMaker drinkMaker;

    public InstructionBuilder(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public String buildBeverageInstructionForDrinkMaker(CustomerOrder customerOrder) {

        String beverageInstruction;

        Double customerGivenMoneyAmount = customerOrder.getGivenMoney();
        Double drinkPrice = customerOrder.getDrinkType().getPrice();

        if (customerGivenMoneyAmount >= drinkPrice) {
            String drinkInstruction = buildDrinkInstruction(
                    customerOrder.getDrinkType(),
                    customerOrder.getIsExtraHotDrink());

            String sugarInstruction = buildSugarInstruction(customerOrder.getNumberOfSugar());

            beverageInstruction = drinkInstruction + sugarInstruction;

            drinkMaker.makeDrink(beverageInstruction);

            return beverageInstruction;
        }

        String alertMessage = buildPriceAlertMessage(customerGivenMoneyAmount, drinkPrice);
        drinkMaker.makeDrink(alertMessage);

        return alertMessage;

    }

    private String buildDrinkInstruction(DrinkTypeEnum drinkType, Boolean isExtraHot) {
        if (isExtraHot && !drinkType.isHeatableDrink()) {
            throw new AssertionError("The provided drink cannot be extra hot");
        }
        return drinkType.getCode().concat(isExtraHot ? "h": "");
    }

    private String buildSugarInstruction(Integer numberOfSugar) {
        boolean isCustomerWantSugar = numberOfSugar > 0;
        String addSugarAndStick = ":".concat(numberOfSugar.toString()).concat(":0");;
        String withoutSugarAndStick = "::";

        return isCustomerWantSugar ? addSugarAndStick : withoutSugarAndStick;
    }

    private String buildPriceAlertMessage(Double customerGivenMoneyAmount, Double drinkPrice ) {
        double amountOfMoneyMissing = drinkPrice - customerGivenMoneyAmount;
        return "You doesn't give enough money to buy your drink : "
                .concat(Double.toString(amountOfMoneyMissing))
                .concat(" € is missing");
    }
}