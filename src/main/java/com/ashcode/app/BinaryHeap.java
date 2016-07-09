package com.ashcode.app;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary heap can be used as a priority queue. How?
 * Irrespective the order in which the input is given, return min never goes to O(n). In a bst, it can
 * be linear if the input is in sorted order. For heap, it is log(n).
 *
 * For insert also log(n). but for bst in worst case it is O(n).
 *
 * Search is O(n). For tree also worst case is O(n).
 *
 * GetMedian..
 *
 * Created by anatarajan on 6/25/16.
 */

public class BinaryHeap {

    private List<Integer> inputArray;

    //Building a max heap
    public BinaryHeap(List<Integer> inputArray){
        this.inputArray = new ArrayList<Integer>();
        this.inputArray = inputArray;
    }

    public List<Integer> getInputArray() {
        return inputArray;
    }

    public void setInputArray(List<Integer> inputArray) {
        this.inputArray = inputArray;
    }

    /*try to make each subtree a heap from ground up
     * for each subtree sift down from root.
     */
    public void heapifyANode(int i){
        int leftIndex = 2*i+1;
        int rightIndex = 2*i+2;
        int largest;

        largest = inputArray.get(i);
        int largeOne = i;

        if(inputArray.size() > leftIndex && largest < inputArray.get(leftIndex)){
            largest = inputArray.get(leftIndex);
            largeOne = leftIndex;
        }
        if(inputArray.size() > rightIndex && largest < inputArray.get(rightIndex)){
            largest = inputArray.get(rightIndex);
            largeOne = rightIndex;
        }

        if(largeOne != i){
            int swapSpace = inputArray.get(i);
            inputArray.set(i,largest);
            inputArray.set(largeOne, swapSpace);
            heapifyANode(largeOne);
        }
    }

    public void heapify(){
        for(int i=inputArray.size()/2; i>=0; i--){
            heapifyANode(i);
        }
    }

    /*
     * insert at the end and sift up..
     */
    public void insert(int newElement){
        inputArray.add(newElement);

        int parent = (inputArray.size()-1)/2;
        int child = inputArray.size() - 1;

        int swapSpace;
        while(parent >= 0 && inputArray.get(parent) < inputArray.get(child)){
            swapSpace = inputArray.get(parent);
            inputArray.set(parent, inputArray.get(child));
            inputArray.set(child,swapSpace);

            child = parent;
            parent = (child-1)/2;
        }
    }

    public int returnMin(){
        int output = inputArray.get(0);
        inputArray.remove(0);
        heapifyANode(0);

        return output;
    }
}
