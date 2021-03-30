package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.CalculateService;

@Controller
public class CaculatorController {

    @Autowired
    private CalculateService calculateService;

    @GetMapping("/")
    public String getHomePage(){
        return "index";
    }
    @PostMapping ("/calculator")
    public String caculate(@RequestParam int num1, @RequestParam int num2, @RequestParam String operator , Model model){
        model.addAttribute("operator",calculateService.calculate(num1,num2,operator));
        return "index";
    }
}
