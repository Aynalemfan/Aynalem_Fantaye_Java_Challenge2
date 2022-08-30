package com.company.monthandmathservice.controller;

import com.company.monthandmathservice.model.RandomMonth;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class RandomMonthController {
//I used class exercises as input in developing this code.
    private static RandomMonth[] randomMonth = {
            new RandomMonth(1, "January"),
            new RandomMonth(2, "February"),
            new RandomMonth(3, "March"),
            new RandomMonth(4, "April"),
            new RandomMonth(5, "May"),
            new RandomMonth(6, "June"),
            new RandomMonth(7, "July"),
            new RandomMonth(8, "August"),
            new RandomMonth(9, "September"),
            new RandomMonth(10, "October"),
            new RandomMonth(11, "November"),
            new RandomMonth(12, "December"),
    };

    @RequestMapping(value = "/randomMonth", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public RandomMonth getRandomMonth() {

        Random randomNumber = new Random();

        return randomMonth[randomNumber.nextInt(12)];
    }
}
