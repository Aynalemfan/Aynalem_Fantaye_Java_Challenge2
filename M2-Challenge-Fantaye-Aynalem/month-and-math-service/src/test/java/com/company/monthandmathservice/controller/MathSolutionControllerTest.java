package com.company.monthandmathservice.controller;

import com.company.monthandmathservice.model.MathSolution;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static java.lang.Float.NaN;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MathSolutionController.class)
public class MathSolutionControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void addShouldReturnTheAdditionOfTwoNumbers() throws Exception {

        MathSolution input = new MathSolution();
        input.setOperand1(10);
        input.setOperand2(5);
        String inputJson = mapper.writeValueAsString(input);

        MathSolution output = new MathSolution();
        output.setOperand1(10);
        output.setOperand2(5);
        output.setAnswer(15);
        output.setOperation("add");

        String outputJson = mapper.writeValueAsString(output);
        mockMvc.perform(
                        post("/add")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void addShouldReturnErrorWhenOperandsAreNotNumber() throws Exception {
        MathSolution input = new MathSolution();
        input.setOperand1(10);
        input.setOperand2((int)NaN);
        input.setOperation("add");
        String inputJson = mapper.writeValueAsString(input);

        MathSolution output = new MathSolution();
        output.setOperand1(10);
        output.setOperand2(5);
        output.setAnswer(15);
        output.setOperation("add");

        mockMvc.perform(
                        post("/add")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }


    @Test
    public void subtractShouldReturnTheDifferenceOfTwoNumbers() throws Exception {
        MathSolution input = new MathSolution();
        input.setOperand1(10);
        input.setOperand2(5);
        String inputJson = mapper.writeValueAsString(input);

        MathSolution output = new MathSolution();
        output.setOperand1(10);
        output.setOperand2(5);
        output.setAnswer(5);
        output.setOperation("subtract");

        String outputJson = mapper.writeValueAsString(output);
        mockMvc.perform(
                        post("/subtract")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));

    }

    @Test
    public void subtractShouldReturn422WhenOperandNotANumber() throws Exception {
        MathSolution input = new MathSolution();
        input.setOperand1(10);
        input.setOperand2((int) NaN);
        input.setOperation("subtract");

        String inputJson = mapper.writeValueAsString(input);
        MathSolution output = new MathSolution();
        output.setAnswer(5);
        output.setOperation("subtract");

        String outputJson = mapper.writeValueAsString(output);

        mockMvc.perform(
                        post("/subtract")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void multiplyShouldReturnTheProductOfTwoNumbers() throws Exception {
        MathSolution input = new MathSolution();
        input.setOperand1(10);
        input.setOperand2(5);
        input.setOperation("multiply");
        String inputJson = mapper.writeValueAsString(input);

        MathSolution output = new MathSolution();
        output.setOperand1(10);
        output.setOperand2(5);
        output.setAnswer(50);
        output.setOperation("multiply");

        String outputJson = mapper.writeValueAsString(output);
        mockMvc.perform(
                        post("/multiply")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void multiplyShouldReturn422WhenOperandAreNotANumber() throws Exception {
        MathSolution input = new MathSolution();
        input.setOperand1(10);
        input.setOperand2((int)NaN);
        input.setOperation("multiply");
        String inputJson = mapper.writeValueAsString(input);

        MathSolution output = new MathSolution();
        output.setOperand1(10);
        output.setOperand2(5);
        output.setAnswer(50);
        output.setOperation("multiply");

        String outputJson = mapper.writeValueAsString(output);
        mockMvc.perform(
                        post("/multiply")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void divideShouldReturnErrorWhenOperandsAreNotANumber() throws Exception {
        MathSolution input = new MathSolution();
        input.setOperand1(10);
        input.setOperand2((int) NaN);
        input.setOperation("divide");

        String inputJson = mapper.writeValueAsString(input);
        MathSolution output = new MathSolution();
        output.setAnswer(2);
        output.setOperation("divide");

        String outputJson = mapper.writeValueAsString(output);

        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
    @Test
    public void divideShouldReturnErrorWhenDividingByZero() throws Exception {
        MathSolution input = new MathSolution();
        input.setOperand1(10);
        input.setOperand2(0);
        input.setOperation("divide");
        String inputJson = mapper.writeValueAsString(input);

        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void divideShouldReturnTheDivisionOfTwoNumbers() throws Exception {
        MathSolution input = new MathSolution();
        input.setOperand1(10);
        input.setOperand2(5);
        input.setOperation("divide");
        String inputJson = mapper.writeValueAsString(input);

        MathSolution output = new MathSolution();
        output.setOperand1(10);
        output.setOperand2(5);
        output.setAnswer(2);
        output.setOperation("divide");

        String outputJson = mapper.writeValueAsString(output);
        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

}