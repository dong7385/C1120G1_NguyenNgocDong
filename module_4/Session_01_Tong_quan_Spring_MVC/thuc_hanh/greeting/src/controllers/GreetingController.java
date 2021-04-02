package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
@Controller
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting(@RequestParam String name,Modle modle) {
        modle.addAttribute("name", name);
        return "index1";
    }

}
