package com.test.vehiclegeo.service;

import com.test.vehiclegeo.persistence.VehicleGeoDAO;
import com.test.vehiclegeo.persistence.domain.Rectangle;
import com.test.vehiclegeo.persistence.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleGeoService {

    @Autowired
    private VehicleGeoDAO vehicleGeoDAO;

    public Optional<Vehicle> findById(int id) {
        return vehicleGeoDAO.findById(id);
    }

    public Vehicle updateVehicleCoords(Vehicle veh) {
        return vehicleGeoDAO.updateCoords(veh.getId(), veh.getPoint());
    }

    public List<Vehicle> findByRectangle(Rectangle r) {
        return vehicleGeoDAO.findByRectangle(r);
    }
}
