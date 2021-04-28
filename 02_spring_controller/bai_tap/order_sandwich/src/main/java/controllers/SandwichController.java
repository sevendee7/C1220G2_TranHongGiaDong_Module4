package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    @GetMapping("/create")
    public String save() {
        return "index";
    }

    @GetMapping("/result")
    public String getCondiments(@RequestParam(name = "lettuce", required = false, defaultValue = "") String lettuce,
                                @RequestParam(name = "tomato", required = false, defaultValue = "") String tomato,
                                @RequestParam(name = "mustard", required = false, defaultValue = "") String mustard,
                                @RequestParam(name = "sprouts", required = false, defaultValue = "") String sprouts,
                                Model model) {
        model.addAttribute("lettuce", lettuce);
        model.addAttribute("tomato", tomato);
        model.addAttribute("mustard", mustard);
        model.addAttribute("sprouts", sprouts);
        return "result";
    }
}
