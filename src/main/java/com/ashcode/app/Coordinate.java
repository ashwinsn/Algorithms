package com.ashcode.app;

import java.util.Comparator;

/**
 * Created by anatarajan on 7/6/16.
 */
public class Coordinate implements Comparable<Coordinate>, Comparator<Coordinate>{
    public int x;
    public int y;
    public int z;

    private double distance;

    public Coordinate(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;

        this.distance = distanceFromOrigin();
    }

    public double distanceFromOrigin(){
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2) + Math.pow(z,2));
    }

    public int compareTo(Coordinate coordinate){
        double coordinateDistanceFromOrigin = coordinate.distanceFromOrigin();
        if(coordinateDistanceFromOrigin > distance){
            return 1;
        } else if(coordinateDistanceFromOrigin == distance){
            return 0;
        } else {
            return -1;
        }
    }

    public int compare(Coordinate c1, Coordinate c2){
        double c1Distance = c1.distanceFromOrigin();
        double c2Distance = c2.distanceFromOrigin();

        if(c1Distance > c2Distance){
            return -1;
        } else if(c1Distance == c2Distance){
            return 0;
        } else {
            return 1;
        }
    }
}
