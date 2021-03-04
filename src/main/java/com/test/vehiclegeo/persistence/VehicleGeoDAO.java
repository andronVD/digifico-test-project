package com.test.vehiclegeo.persistence;

import com.test.vehiclegeo.persistence.domain.Point;
import com.test.vehiclegeo.persistence.domain.Rectangle;
import com.test.vehiclegeo.persistence.domain.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface VehicleGeoDAO extends CrudRepository<Vehicle, Integer> {

    default List<Vehicle> findByRectangle(Rectangle r) {
        List<Vehicle> res = new ArrayList<>();

        res.add(new Vehicle(1, Point.of(0,0)));
        res.add(new Vehicle(2, Point.of(1,1)));
        res.add(new Vehicle(3, Point.of(2,2)));

        return res;
    };

    default Vehicle updateCoords(int id, Point point) {
        return new Vehicle(1, Point.of(1,1));
    };

}
