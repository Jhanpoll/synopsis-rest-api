package pe.com.synopsis.training.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Country")
@Controller
public class CountryController {
    @Autowired
    public WsCountryClient client;

    @GetMapping(value="/{name}")
    public GetCountryResponse getCountryGet(@PathVariable(name="name") String name) {
        //model.addAttribute("name", name);
        GetCountryResponse country = client.findByName(name);
        return country;

    }

    //@PostMapping("/greeting")
    @PostMapping()
    public GetCountryResponse(@ModelAttribute("name") String name) {
        //model.addAttribute("name", name);
        //LOG.info(name);
        GetCountryResponse country = client.findByName(name);
        return country;
    }
}

