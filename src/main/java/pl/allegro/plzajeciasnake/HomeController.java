package pl.allegro.plzajeciasnake;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Łukasz on 12.10.2015.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String mainPage(){
        return "index";
    }

}
