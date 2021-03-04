package com.test.vehiclegeo.persistence.domain;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Point of(int xCoord, int yCoord) {
        return new Point(xCoord, yCoord);
    }
}
