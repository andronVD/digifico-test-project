package com.test.vehiclegeo.api;

import com.test.vehiclegeo.api.domain.VehicleGeo;
import com.test.vehiclegeo.persistence.domain.Point;
import com.test.vehiclegeo.persistence.domain.Rectangle;
import com.test.vehiclegeo.persistence.domain.Vehicle;
import com.test.vehiclegeo.service.VehicleGeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vehicle")
public class VehicleGeoResource {

    @Autowired
    private VehicleGeoService vehService;

    @PostMapping("/coords")
    public VehicleGeo updateCoords(@RequestBody VehicleGeo vehicleGeo) {
        Vehicle vehicle = vehService.findById(vehicleGeo.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Vehicle not found")));

        Point newCoords = Point.of(vehicleGeo.getXCoord(), vehicleGeo.getYCoord());
        return VehicleGeo.from( vehService.updateVehicleCoords(vehicle.withCoords(newCoords)) );
    }


    //XXX I'd better replace request params with request body like Rectangle object
    @PostMapping("/by/rectangle")
    public List<VehicleGeo> findByRectangle(@RequestBody Rectangle rectangle) {
        return vehService.findByRectangle(rectangle).stream().map(VehicleGeo::from).collect(Collectors.toList());
    }

}
