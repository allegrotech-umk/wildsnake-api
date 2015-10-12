package pl.umk.simo.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Szymon on 12.10.2015.
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){ return "index"; }

}
