package com.springmvc.service;

import com.springmvc.controller.divideByZeroControllerAdvice;
import org.springframework.stereotype.Service;

@Service
public class calculatorService {

    public int doOperation(String num1, String num2,String operation) throws divideByZeroControllerAdvice {

        Integer number1 = Integer.parseInt(num1);
        Integer number2 = Integer.parseInt(num2);
        Integer answer = 0;

        switch (operation){

            case "+":
                answer = number1 + number2;
                break;
            case "-":
                answer = number1 - number2;
                break;
            case "*":
                answer = number1 * number2;
                break;
            case "/":
                if(number2 == 0)
                    throw new divideByZeroControllerAdvice();
                answer = number1 / number2;
                break;

        }
        return answer;
    }

}
