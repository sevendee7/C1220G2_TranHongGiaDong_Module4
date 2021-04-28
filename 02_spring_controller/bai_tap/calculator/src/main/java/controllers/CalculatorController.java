package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @RequestMapping("/calculator")
    public String getCalculator() {
        return "index";
    }

    @GetMapping("/result")
    public String result(@RequestParam Double number1,
                         @RequestParam Double number2,
                         @RequestParam String operator,
                         Model model) {
        Double result = 0.0;
    model.addAttribute("number1",number1);
    model.addAttribute("number2",number2);
    model.addAttribute("operator",operator);
    switch (operator) {
        case "+":
            result = number1 + number2;
            break;
        case "-":
            result = number1 - number2;
            break;
        case "*":
            result = number1 * number2;
            break;
        case "/":
            result = number1 / number2;
            break;
    }
    model.addAttribute("result",result);
    return "result";
    }
}
