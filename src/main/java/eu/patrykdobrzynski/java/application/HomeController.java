package eu.patrykdobrzynski.java.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Patryk on 2015-10-12.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String mainPage() {
        return "index";
    }
}
