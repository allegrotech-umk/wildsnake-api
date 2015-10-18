package pl.jwest.wildsnake.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Value("${welcome.message}")
    String message;

    @RequestMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("hello", message);
        return "index";
    }

}
