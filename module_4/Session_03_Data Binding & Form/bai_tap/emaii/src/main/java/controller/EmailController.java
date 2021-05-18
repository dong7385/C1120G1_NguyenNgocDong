package controller;

import model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {
    //    @PostMapping("/email")
//    public String createEmailPage(@ModelAttribute("email") Email email, Model model) {
//        model.addAttribute("languages", email.getLanguages());
//        model.addAttribute("pageSize", email.getPageSize());
//        model.addAttribute("filter", email.getFilter());
//        model.addAttribute("signature", email.getSignature());
//        return "email/result";
//    }
    @PostMapping("/email")
    public ModelAndView createEmailPage(@ModelAttribute("email") Email email) {
        return new ModelAndView("email/result", "email", email);
    }

    @GetMapping("/")
    public ModelAndView showEmailPage(@ModelAttribute Email email) {
        return new ModelAndView("email/list", "email", email);
    }
}
