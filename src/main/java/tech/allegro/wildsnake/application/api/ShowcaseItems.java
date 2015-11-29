package tech.allegro.wildsnake.application.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ShowcaseItems {

    @RequestMapping(method = RequestMethod.GET, value = "/api/showcase/items")
    public List<ShowcaseItems> getItems() {
        return new ArrayList<>();
    }

}
