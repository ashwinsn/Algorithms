package com.ashcode.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by anatarajan on 6/1/16.
 */
public class SmallestSetOfIntervalsCoveringATargetRange {

    List<Interval> setOfIntervals;
    Interval targetInterval;
    HashMap<Interval, List<Interval>> memoizationTableOfIntervals;

    public SmallestSetOfIntervalsCoveringATargetRange(List<Interval> setOfIntervals){
        this.setOfIntervals = setOfIntervals;
        memoizationTableOfIntervals = new HashMap<Interval, List<Interval>>();
    }

    public List<Interval> getSetOfIntervals() {
        return setOfIntervals;
    }

    public void setSetOfIntervals(List<Interval> setOfIntervals) {
        this.setOfIntervals = setOfIntervals;
        initializeMemoizationTable();
    }

    public void setTargetInterval(Interval targetInterval){
        this.targetInterval = targetInterval;
        initializeMemoizationTable();
    }

    public List<Interval> execute(){
        for(int i=targetInterval.getBegin(); i <= targetInterval.getEnd(); i++){

            int currentIntervalSize = 0;
            Interval currentInterval = null;
            List<Interval> currentList = null;
            List<Interval> listToBeAdded = null;
            int minListSize = setOfIntervals.size();

            for(int j=targetInterval.getBegin(); j<i; j++){

                currentInterval = new Interval(targetInterval.getBegin(), j);
                currentList = memoizationTableOfIntervals.get(currentInterval);
                listToBeAdded = currentList != null ? new ArrayList<Interval>(currentList) : new ArrayList<Interval>();

                int currentListSize = currentList != null ? currentList.size() : 0;
                if(currentListSize < minListSize){
                    for(Interval interval : setOfIntervals){
                        if(currentList == null && (interval.getBegin() <= targetInterval.getBegin()
                                && interval.getEnd() >= i) || (currentList != null && interval.getEnd() > i)){
                            listToBeAdded.add(interval);
                            minListSize = currentListSize;
                            break;
                        }
                    }
                }
            }
            memoizationTableOfIntervals.put(new Interval(targetInterval.getBegin(), i), listToBeAdded);
        }
        return memoizationTableOfIntervals.get(new Interval(targetInterval.getBegin(), targetInterval.getEnd()));
    }

    private void initializeMemoizationTable() {
        for(int i=targetInterval.getBegin(); i <= targetInterval.getEnd(); i++){
            memoizationTableOfIntervals.put(new Interval(targetInterval.getBegin(), i), new ArrayList<Interval>());
        }
    }


    /*  [1,3] [2,4]
     *    1,4
     *    naive : find all combinations that satisfy the range
     *    and return the smallest set.
     *
     *  Does it satisfy optimal sub structure??
     */


}
