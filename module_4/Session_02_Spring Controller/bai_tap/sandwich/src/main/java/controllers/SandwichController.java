package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String homeController() {
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam(value = "condiment",defaultValue = "none") String condiment, Model model) {
        model.addAttribute("condiment", condiment);
        return "result";
    }
}
