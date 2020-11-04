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
    public void should_build_proper_instruction_for_buildMaker() {
        CustomerOrder customerOrder = new CustomerOrder(DrinkTypeEnum.COFFEE, 0);

        String buildInstructions = instructionBuilder.buildBeverageInstructionForDrinkMaker(customerOrder);

        assertThat(buildInstructions).isEqualTo("C::");
    }

    @Test
    public void should_build_proper_instruction_with_sugar_stick() {
        CustomerOrder customerOrder = new CustomerOrder(DrinkTypeEnum.TEA, 2);

        String buildInstructions = instructionBuilder.buildBeverageInstructionForDrinkMaker(customerOrder);

        assertThat(buildInstructions).isEqualTo("T:2:0");
    }
}