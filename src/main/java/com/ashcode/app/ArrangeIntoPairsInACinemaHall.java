package com.ashcode.app;

import java.util.HashMap;
import java.util.List;

/**
 * Created by anatarajan on 10/31/15.
 */

public class ArrangeIntoPairsInACinemaHall {

    String seatingArragement;
    HashMap<Character, List<Integer>> seatingHash = new HashMap<Character, List<Integer>>();

    public ArrangeIntoPairsInACinemaHall(String seatingArrangement){
        this.seatingArragement = seatingArrangement;
    }

    public HashMap<Character, List<Integer>> getSeatingHash(){
        return seatingHash;
    }

    public void buildSeatingHashTable(){

        for(int i=0; i< seatingArragement.length(); i++){

        }
    }

}
