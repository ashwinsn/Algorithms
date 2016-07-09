package com.ashcode.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by anatarajan on 5/28/16.
 */
public class MergeIntervals {

    List<Interval> intervalList1;
    List<Interval> intervalList2;
    List<Interval> mergedIntervals;

    public MergeIntervals(){}

    public void setIntervals(List<Interval> intervalList1, List<Interval> intervalList2){
        this.intervalList1 = intervalList1;
        this.intervalList2 = intervalList2;
        this.mergedIntervals = new ArrayList<Interval>();
    }

    public void execute(){
       Iterator<Interval> list1Iterator = intervalList1.iterator();
       Iterator<Interval> list2Iterator = intervalList2.iterator();

       Interval interval1 = list1Iterator.next();
       Interval interval2 = list2Iterator.next();

        while(interval1 != null && interval2 != null) {
            try {
                int comparison = Interval.compare(interval1, interval2);
                if (comparison > 0) {
                    mergedIntervals.add(interval2);
                    interval2 = getNextElement(list2Iterator);

                } else if (comparison < 0) {
                    mergedIntervals.add(interval1);
                    interval1 = getNextElement(list1Iterator);
                } else {
                    int newIntervalX = interval1.getBegin() >= interval2.getBegin() ? interval2.getBegin() : interval1.getBegin();
                    int newIntervalY = interval1.getEnd() >= interval2.getEnd() ? interval1.getEnd() : interval2.getEnd();
                    Interval newInterval = new Interval(newIntervalX, newIntervalY);
                    mergedIntervals.add(newInterval);

                    interval2 = getNextElement(list2Iterator);
                    interval1 = getNextElement(list1Iterator);
                }
            } catch(NoSuchElementException e){
                break;
            }

        }
        while(interval1 != null){
            mergedIntervals.add(interval1);
            interval1 = getNextElement(list1Iterator);
        }
        while(interval2 != null){
            mergedIntervals.add(interval2);
            interval2 = getNextElement(list2Iterator);
        }
    }

    private Interval getNextElement(Iterator<Interval> iterator) {
        if(iterator.hasNext()){
            return iterator.next();
        } else {
            return null;
        }
    }

    public List<Interval> getMergedIntervals() {
        return mergedIntervals;
    }
}
