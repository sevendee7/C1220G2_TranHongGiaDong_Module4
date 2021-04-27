package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingSpring {
    @GetMapping("/home")
    public String getGreeting() {
        return "/index";
    }
}
