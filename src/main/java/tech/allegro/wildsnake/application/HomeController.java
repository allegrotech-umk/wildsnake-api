package tech.allegro.wildsnake.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tech.allegro.wildsnake.showcase.model.ShowcaseItem;
import tech.allegro.wildsnake.showcase.service.ShowcaseService;

import java.util.List;

@Controller
public class HomeController {

    private final ShowcaseService showcaseService;

    @Value("${mainpage.message}")
    private String pageMessage;

    @Autowired
    public HomeController(ShowcaseService showcaseService) {
        this.showcaseService = showcaseService;
    }

    @RequestMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("pageMessage", pageMessage);
        model.addAttribute("showcaseItems", showcaseService.getItems());
        return "index";
    }

}
