package com.project.citiesapi.cities.controller;

import com.project.citiesapi.cities.service.DistanceService;
import com.project.citiesapi.cities.service.EarthRadiusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/distances")
public class DistanceController {

    private DistanceService distanceService;
    Logger log = LoggerFactory.getLogger(DistanceController.class);

    public DistanceController(DistanceService distanceService) {
        this.distanceService = distanceService;
    }

    @GetMapping("/by-points")
    public Double byPoints(@RequestParam(name = "from") final Long city1,
                           @RequestParam(name = "to") final Long city2) {
        log.info("byPoints");
        return distanceService.distanceByPointsInMiles(city1, city2);
    }

    @GetMapping("/by-cube")
    public Double byCube(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2) {
        log.info("byCube");
        return distanceService.distanceByCubeInMeters(city1, city2);
    }

    @GetMapping("/by-math")
    public Double byMath(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2,
                         @RequestParam final EarthRadiusService unit) {
        log.info("byMath");
        return distanceService.distanceUsingMath(city1, city2, unit);
    }

}
