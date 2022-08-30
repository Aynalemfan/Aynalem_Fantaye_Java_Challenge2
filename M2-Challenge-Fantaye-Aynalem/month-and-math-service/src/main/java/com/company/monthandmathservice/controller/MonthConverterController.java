package com.company.monthandmathservice.controller;

import com.company.monthandmathservice.model.MonthConverter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MonthConverterController {

    private List<MonthConverter> monthList = new ArrayList<>(Arrays.asList(
            new MonthConverter(1,"January"),
            new MonthConverter(2,"February"),
            new MonthConverter(3,"March"),
            new MonthConverter(4,"April"),
            new MonthConverter(5,"May"),
            new MonthConverter(6,"June"),
            new MonthConverter(7,"July"),
            new MonthConverter(8,"August"),
            new MonthConverter(9,"September"),
            new MonthConverter(10,"October"),
            new MonthConverter(11,"November"),
            new MonthConverter(12,"December")
    ));

    @GetMapping("/month/{monthNumber}")
    @ResponseStatus(HttpStatus.OK)
    public MonthConverter getMonthByNumber(@PathVariable int monthNumber,String name) {
        if (monthNumber < 1 || monthNumber > 12) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"Invalid Month Number Specified");

        } else {
            return monthList.get(monthNumber - 1);

        }

    }
}



