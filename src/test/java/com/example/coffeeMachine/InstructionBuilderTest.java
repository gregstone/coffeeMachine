package com.example.coffeeMachine;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;

public class InstructionBuilderTest {

    private InstructionBuilder instructionBuilder;

    @Mock
    private DrinkMaker drinkMaker;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        instructionBuilder = new InstructionBuilder(drinkMaker);
    }

    @Test
    public void should_build_proper_instruction_without_sugar_stick() {
        CustomerOrder customerOrder = new CustomerOrder(
                DrinkTypeEnum.COFFEE,
                0,
                DrinkTypeEnum.COFFEE.getPrice(),
                false);

        String buildInstructions = instructionBuilder.buildBeverageInstructionForDrinkMaker(customerOrder);

        assertThat(buildInstructions).isEqualTo("C::");
    }

    @Test
    public void should_build_proper_instruction_with_sugar_stick() {
        CustomerOrder customerOrder = new CustomerOrder(
                DrinkTypeEnum.TEA,
                2,
                DrinkTypeEnum.TEA.getPrice(),
                false);

        String buildInstructions = instructionBuilder.buildBeverageInstructionForDrinkMaker(customerOrder);

        assertThat(buildInstructions).isEqualTo("T:2:0");
    }

    @Test
    public void should_build_price_alert_message_without_enough_money() {
        Double amountToSubtract = 0.2;
        Double providedAmountOfMoney = DrinkTypeEnum.TEA.getPrice() - amountToSubtract;

        CustomerOrder customerOrder = new CustomerOrder(
                DrinkTypeEnum.TEA,
                2,
                providedAmountOfMoney,
                false);

        String buildInstructions = instructionBuilder.buildBeverageInstructionForDrinkMaker(customerOrder);

        String expectedAlertMessage = "You doesn't give enough money to buy your drink : "
                .concat(amountToSubtract.toString())
                .concat(" € is missing");

        assertThat(buildInstructions).isEqualTo(expectedAlertMessage);
    }

    @Test
    public void should_build_proper_instruction_for_extra_hot_drink() {
        CustomerOrder customerOrder = new CustomerOrder(
                DrinkTypeEnum.COFFEE,
                2,
                DrinkTypeEnum.COFFEE.getPrice(),
                true);

        String buildInstructions = instructionBuilder.buildBeverageInstructionForDrinkMaker(customerOrder);

        assertThat(buildInstructions).isEqualTo("Ch:2:0");
    }

    @Test(expected = AssertionError.class)
    public void should_failed_with_assertion_error_for_extra_hot_juice() {
        CustomerOrder customerOrder = new CustomerOrder(
                DrinkTypeEnum.ORANGE_JUICE,
                0,
                DrinkTypeEnum.ORANGE_JUICE.getPrice(),
                true);

        instructionBuilder.buildBeverageInstructionForDrinkMaker(customerOrder);
    }
}