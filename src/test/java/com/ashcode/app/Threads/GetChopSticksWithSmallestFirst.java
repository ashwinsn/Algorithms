package com.ashcode.app.Threads;

import java.util.ArrayList;

/**
 * Created by anatarajan on 4/27/16.
 */
public class GetChopSticksWithSmallestFirst implements GetChopSticks {
    public ArrayList<ChopStick> getChopSticks(ChopStick one, ChopStick two){
        ArrayList<ChopStick> returnList = new ArrayList<ChopStick>();
        if(one.id < two. id){
            returnList.add(one);
            returnList.add(two);
        } else {
            returnList.add(two);
            returnList.add(one);
        }

        return returnList;
    }
}
