package com.ashcode.app;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 10/30/15.
 */

class outputResult{
    public void setStartRange(int startRange) {
        this.startRange = startRange;
    }

    public int getEndRange() {
        return endRange;
    }

    int startRange;
    int endRange;

    public outputResult(int startRange, int endRange){
        this.startRange = startRange;
        this.endRange = endRange;
    }
};

public class FindSubArraysThatAddToSum {

    int[] inputArray;
    List<List<Integer>> partialResult;

    public FindSubArraysThatAddToSum(int[] inputArray){

        this.inputArray = inputArray;
        partialResult = new ArrayList<List<Integer>>();
    }

    //Returns a 2d where [i,j] represents sum from i..j.
    public List<List<Integer>> calculatePartialSums(int endRange){
        if(endRange > 0) {
            List<List<Integer>> partialResult = calculatePartialSums(endRange - 1);
            for (List<Integer> singlePartialResult : partialResult) {
                singlePartialResult.add(singlePartialResult.get(endRange - 1) + inputArray[endRange]);
            }
        }
        List<Integer> newYDimensionList = new ArrayList<Integer>();
        newYDimensionList.add(new Integer(inputArray[endRange]));
        partialResult.add(newYDimensionList);

        return partialResult;
    }

    public List<outputResult> findSum(){


        List<outputResult> output = new ArrayList<outputResult>();

        output.add(new outputResult(2,3));

        return output;
    }

}
