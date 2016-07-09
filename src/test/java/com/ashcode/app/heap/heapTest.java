package com.ashcode.app.heap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by anatarajan on 3/24/16.
 */
public class heapTest {

    int[] someArray = {2, 3, 4, 8, -2};
    Heap subject = new Heap(someArray, true);

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testHeapify() throws Exception {
        for(int number : someArray){
            System.out.print(number + ",");
        }
        System.out.println();
        subject.minHeapify();
        for(int number : someArray){
            System.out.print(number + ",");
        }
        for(int i=0; i<someArray.length; i++){
            if(2*i + 1 < someArray.length && someArray[i] > someArray[2*i + 1] ||
                    2*i + 2 < someArray.length && someArray[i] > someArray[2*i + 2]){
                assert(false);
                break;
            }
        }
        assert(true);
    }

    @Test
    public void testInsertIntoHeap() throws Exception {

    }
}