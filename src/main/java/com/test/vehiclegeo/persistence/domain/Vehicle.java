package com.test.vehiclegeo.persistence.domain;

public class Vehicle {

    private int id;
    private Point point;

    public Vehicle(int id, Point point) {
        this.id = id;
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public Point getPoint() {
        return point;
    }

    public Vehicle withCoords(Point p) {
        this.point = p;
        return this;
    }

}
