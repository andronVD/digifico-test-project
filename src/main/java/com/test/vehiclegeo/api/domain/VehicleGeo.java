package com.test.vehiclegeo.api.domain;

import com.test.vehiclegeo.persistence.domain.Point;
import com.test.vehiclegeo.persistence.domain.Vehicle;

public class VehicleGeo {

    private int id;
    private int xCoord;
    private int yCoord;

    public VehicleGeo(int id, int x, int y) {
        this.id = id;
        this.xCoord = x;
        this.yCoord = y;
    }

    public int getId() {
        return id;
    }

    public int getXCoord() {
        return xCoord;
    }

    public int getYCoord() {
        return yCoord;
    }

    public static VehicleGeo from(Vehicle v) {
        Point p = v.getPoint();
        return new VehicleGeo(v.getId(), p.getX(), p.getY());
    }

}
