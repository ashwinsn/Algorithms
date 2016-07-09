package com.ashcode.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by anatarajan on 7/7/16.
 */
public class FindNearestKStarsFromBillionStars {

    int k;
    private ArrayList<Coordinate> stars;
    public PriorityQueue<Coordinate> heap;

    public FindNearestKStarsFromBillionStars(int k, ArrayList<Coordinate> stars){
        this.k = k;
        this.stars = stars;
        heap = new PriorityQueue(k, new Coordinate(0,0,0));
    }

    public void addStarToHeap(Coordinate star){
        heap.add(star);
        if(heap.size() > k){
            heap.poll();
        }
    }

    public static void main(String args[]){
        ArrayList<Coordinate> stars = new ArrayList<Coordinate>();
        stars.add(new Coordinate(1,2,3));
        stars.add(new Coordinate(2,3,4));
        stars.add(new Coordinate(0,1,2));

        FindNearestKStarsFromBillionStars nearestKStars = new FindNearestKStarsFromBillionStars(1,stars);
        for(Coordinate star : stars){
            nearestKStars.addStarToHeap(star);
        }

        Iterator<Coordinate> heapIterator = nearestKStars.heap.iterator();
        while(heapIterator.hasNext()){
            Coordinate star = heapIterator.next();
            System.out.println(star.x);
        }
    }


}
