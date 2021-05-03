package com.LocationTracking.TrackingSoftware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.LocationTracking.TrackingSoftware.utility.RestClient;

@RestController
public class LocationRealTimeController {

    @Autowired
    RestClient r1;

    @GetMapping("/AlexanderLocations")
    public String getAlexanderLocations() {
        String AlexanderLocation = r1.get("/Tracking_Alexander.json");
        return AlexanderLocation;
    }

    @GetMapping("/PhillipLocations")
    public String getPhillipLocations() {
        String PhillipLocations = r1.get("/Tracking_Phillip.json");
        return PhillipLocations;
    }

    @GetMapping("/MartinLocations")
    public String getMartinLocations() {
        String MartinLocations = r1.get("/Tracking_Martin.json");
        return MartinLocations;
    }

    @GetMapping("/MarkusLocations")
    public String getMarkusLocations() {
        String MarkusLocations = r1.get("/Tracking_Markus.json");
        return MarkusLocations;
    }
}
