package com.ashcode.app.heap;

/**
 * Created by anatarajan on 3/24/16.
 */
public class Heap {

    private int[] arrayOfNumbers;
    private final boolean minHeap;

    public Heap(int[] arrayOfNumbers, boolean minHeap){
        this.arrayOfNumbers = arrayOfNumbers;
        this.minHeap = minHeap;
    }

    //Why do we have to siftdown starting from last parent and why not from first parent?
    //Technically we are trying to put each parent in its final place say. If we start with first parent and sift down,
    //it is possible that we lose the place or lose track of the subsequent parents below. So its better to do it from
    //last parent may be.
    public void minHeapifyAParent(int parentIndex){
        int left_kid = parentIndex * 2 + 1;
        int right_kid = parentIndex * 2 + 2;

        char smallest = 'p';
        int smallestNumber = arrayOfNumbers[parentIndex];
        int temp;

        if(left_kid <= arrayOfNumbers.length - 1 && arrayOfNumbers[left_kid] < arrayOfNumbers[parentIndex]){
            smallestNumber = arrayOfNumbers[left_kid];
            smallest = 'l';
        }

        if(right_kid <= arrayOfNumbers.length - 1 && arrayOfNumbers[right_kid] < arrayOfNumbers[parentIndex]){
            smallestNumber = arrayOfNumbers[right_kid];
            smallest = 'r';
        }

        if(smallestNumber != arrayOfNumbers[parentIndex]){
            temp = arrayOfNumbers[parentIndex];
            arrayOfNumbers[parentIndex] = smallestNumber;
            if(smallest == 'l'){
                arrayOfNumbers[left_kid] = temp;
            } else {
                arrayOfNumbers[right_kid] = temp;
            }
        }
    }

    public void minHeapify(){
        for(int i= arrayOfNumbers.length/2; i >= 0; i--){
            minHeapifyAParent(i);
        }
    }

    public void maxHeapify(){

    }

    public void insertIntoMinHeap(int number){

    }

    public void insertIntoMaxHeap(int number){

    }
}
