package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class TuDienController {
    @GetMapping("/")
    public String Home() {
        return "index";
    }
@PostMapping("/convert")
    public String convert(@RequestParam String word, Model model) {
        Map<String, String> map = new TreeMap<>();
        map.put("hello", "Xin chào");
        map.put("how", "Thế nào");
        map.put("book", "Quyển vở");
        map.put("computer", "Máy tính");
        String search = map.get(word);
        if (search == null) {
           model.addAttribute("search","Word not found");
        } else {

            model.addAttribute("search", search);
        }
        return "result";
    }
}

