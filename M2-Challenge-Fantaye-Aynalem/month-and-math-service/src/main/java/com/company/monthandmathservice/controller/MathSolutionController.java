package com.company.monthandmathservice.controller;

import com.company.monthandmathservice.model.MathSolution;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotEmpty;

import static java.lang.Float.NaN;

@RestController
@ResponseBody
public class MathSolutionController {
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    private MathSolution add(@RequestBody @NotEmpty MathSolution mathProblem) {
        int operand1 = mathProblem.getOperand1();
        int operand2 = mathProblem.getOperand2();
        if (operand1 == NaN || operand2 == NaN){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"You must supply two numbers");
        }
        int correctSum = operand1 + operand2;
        mathProblem.setAnswer(correctSum);
        mathProblem.setOperation("add");
            return mathProblem;
    }

    @RequestMapping(value = "/subtract", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    private MathSolution subtract(@RequestBody MathSolution mathProblem) {
        int operand1 = mathProblem.getOperand1();
        int operand2 = mathProblem.getOperand2();
        if (operand1 == NaN || operand2 == NaN){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"You must supply two numbers");
        }
        int correctSubtract = operand1 - operand2;
        mathProblem.setAnswer(correctSubtract);
        mathProblem.setOperation("subtract");
            return mathProblem;
    }

    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    private MathSolution multiply(@RequestBody MathSolution mathProblem) {
        int operand1 = mathProblem.getOperand1();
        int operand2 = mathProblem.getOperand2();
        if (operand1 == NaN || operand2 == NaN){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"You must supply two numbers");
        }
        int correctProduct = operand1 * operand2;
        mathProblem.setAnswer(correctProduct);
        mathProblem.setOperation("multiply");
        return mathProblem;
    }

    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    private MathSolution divide(@RequestBody MathSolution mathProblem) {
        int operand1 = mathProblem.getOperand1();
        int operand2 = mathProblem.getOperand2();
        if (operand2 == 0){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"You must supply valid numbers");
        }
        if (operand1 == NaN || operand2 == NaN){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"You must supply two numbers");
        }
        int correctDivision = operand1 / operand2;
        mathProblem.setAnswer(correctDivision);
        mathProblem.setOperation("divide");
        return mathProblem;
    }
}



