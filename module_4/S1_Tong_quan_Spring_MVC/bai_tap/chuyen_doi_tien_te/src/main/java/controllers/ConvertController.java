package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam int usd, @RequestParam int rate, Model model) {
        int vnd = usd * rate;
model.addAttribute("usd",usd);
model.addAttribute("rate",rate);
model.addAttribute("vnd",vnd);
        return "result";
    }
}
