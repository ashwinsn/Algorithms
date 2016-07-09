package com.ashcode.app.Threads;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by anatarajan on 4/27/16.
 */
public class GetChopSticksInRandomOrder implements GetChopSticks {
    public ArrayList<ChopStick> getChopSticks(ChopStick one, ChopStick two){
        Random randomNumber = new Random();
        int currentNumber = randomNumber.nextInt(2) + 1;

        ArrayList<ChopStick> returnList = new ArrayList<ChopStick>();
        if(currentNumber == 1){
            returnList.add(one);
            returnList.add(two);
        } else {
            returnList.add(two);
            returnList.add(one);
        }

        return returnList;
    }
}
