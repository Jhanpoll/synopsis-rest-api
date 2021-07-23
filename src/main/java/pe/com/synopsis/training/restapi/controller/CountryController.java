package pe.com.synopsis.training.restapi.controller;

import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import jdk.internal.net.http.common.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.com.synopsis.client.soap.WsCountryClient;

@RestController
@RequestMapping("/Country")

public class CountryController {



    @Autowired
    public WsCountryClient client;


    @GetMapping(value ="/{name}")

    public GetCountryResponse getCountryGet(@PathVariable(name="name") String name) {
        //model.addAttribute("name", name);
        GetCountryResponse country = client.findByName(name);
        return country;

    }

    //@PostMapping("/greeting")
    @PostMapping()
    public GetCountryResponse getCountryResponse(@ModelAttribute("name") String name) {
        //model.addAttribute("name", name);
        //LOG.info(name);
        GetCountryResponse country = client.findByName(name);
        return country;
    }
}

