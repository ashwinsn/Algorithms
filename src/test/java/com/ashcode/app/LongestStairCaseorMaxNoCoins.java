package com.ashcode.app;

import java.util.HashMap;
import java.util.List;

/**
 * Created by anatarajan on 5/28/16.
 */
public class LongestStairCaseorMaxNoCoins {
    List<PairOfCoordinates> pairsOfCoordinates;
    HashMap<PairOfCoordinates,Integer> maxStairCaseSizeFromThisPair;

    public LongestStairCaseorMaxNoCoins(List<PairOfCoordinates> pairsOfCoordinates){
        this.pairsOfCoordinates = pairsOfCoordinates;
        maxStairCaseSizeFromThisPair = new HashMap<PairOfCoordinates, Integer>();
    }

    public List<PairOfCoordinates> getPairsOfCoordinates() {
        return pairsOfCoordinates;
    }

    public void setPairsOfCoordinates(List<PairOfCoordinates> pairsOfCoordinates) {
        this.pairsOfCoordinates = pairsOfCoordinates;
    }


    public Integer getLongestStairCase(PairOfCoordinates startingPair){
        int maxStairCaseSize = 0;
        if(pairsOfCoordinates.isEmpty() || pairsOfCoordinates.size() == 1){
            maxStairCaseSizeFromThisPair.put(startingPair, 1);
            return 1;
        }
      else {
            for(PairOfCoordinates pair : pairsOfCoordinates) {
               if(pair.getX() > startingPair.getX() && pair.getY() > startingPair.getY()){
                   Integer currentStairCaseFromThisPair = maxStairCaseSizeFromThisPair.get(pair);
                   if(currentStairCaseFromThisPair != null && currentStairCaseFromThisPair > maxStairCaseSize){
                       maxStairCaseSize = currentStairCaseFromThisPair;
                   } else if(currentStairCaseFromThisPair == null){
                       Integer currentStairCaseSize = getLongestStairCase(pair);
                       if(currentStairCaseSize > maxStairCaseSize){
                           maxStairCaseSize = currentStairCaseSize;
                       }
                   }
                   getLongestStairCase(pair);
               }
            }
            maxStairCaseSizeFromThisPair.put(startingPair, maxStairCaseSize + 1);
        }
        return maxStairCaseSize + 1;
    }
}
