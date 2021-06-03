package com.project.citiesapi.cities.controller;

import com.project.citiesapi.cities.service.DistanceService;
import com.project.citiesapi.cities.service.EarthRadiusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Double> byPoints(@RequestParam(name = "from") final Long city1,
                                   @RequestParam(name = "to") final Long city2) {
        log.info("byPoints");
        return ResponseEntity.ok().body(distanceService.distanceByPointsInMiles(city1, city2));
    }

    @GetMapping("/by-cube")
    public ResponseEntity<Double> byCube(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2) {
        log.info("byCube");
        return ResponseEntity.ok().body(distanceService.distanceByCubeInMeters(city1, city2));
    }

    @GetMapping("/by-math")
    public ResponseEntity<Double> byMath(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2,
                         @RequestParam final EarthRadiusService unit) {
        log.info("byMath");
        return ResponseEntity.ok().body(distanceService.distanceUsingMath(city1, city2, unit));
    }

}
