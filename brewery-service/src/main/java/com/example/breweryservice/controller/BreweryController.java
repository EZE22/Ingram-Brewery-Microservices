package com.example.breweryservice.controller;

import com.example.breweryservice.entity.Beer;
import com.example.breweryservice.entity.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BreweryController {

    private final EurekaClient client;

    @Autowired
    public BreweryController(EurekaClient client) {
        this.client = client;
    }

    //http://localhost:8002/
    @GetMapping("/")
    public String getBreweryHome() {
        RestTemplate restTemplate = new RestTemplate();

        InstanceInfo instanceInfo = client.getNextServerFromEureka("beer-service", false);
        String beerServiceURL = instanceInfo.getHomePageUrl();

        String beerServiceMessage = restTemplate.getForObject(beerServiceURL, String.class);

        return "Welcome to Ingram Brewery!! " + beerServiceMessage;
    }

    //http://localhost:8002/menu
    @RequestMapping("/menu")
    public String getMenu() {

        RestTemplate template = new RestTemplate();
        InstanceInfo instanceInfo = client.getNextServerFromEureka("beer-service", false);
        String beerURL = instanceInfo.getHomePageUrl();
        beerURL = beerURL + "/all-beers";
        String menu = template.getForObject(beerURL, String.class);

        return "Beers: " + menu;
    }

    //TODO add get all user

    //After adding the User
    //http://localhost:8002/Adam Ingram
    @GetMapping("/{name}")
    public String getBeerOrder(@PathVariable("name") String name) {

        RestTemplate template = new RestTemplate();
        Beer beer = new Beer();
        User user = new User();

        //Fetching User info
        InstanceInfo instanceInfo = client.getNextServerFromEureka("user-service", false);
        String userURL = instanceInfo.getHomePageUrl();
        userURL = userURL + name;
        user = template.getForObject(userURL, User.class);

        //Fetching Beer info
        instanceInfo = client.getNextServerFromEureka("beer-service",false);
        String beerURL = instanceInfo.getHomePageUrl();
        beerURL = beerURL + "/beer-id/" + user.getBeerid();
        beer = template.getForObject(beerURL, Beer.class);

        return("Order: \n"
                + "Customer name: " + user.getUsername() + "\n"
                + "Beer Order: " + beer.getBeername()
                + " Inventory: " + beer.getQuantityonhand()
        );

    }

}
