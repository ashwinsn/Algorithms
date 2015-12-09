package com.ashcode.app;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by anatarajan on 10/31/15.
 */
public class ArrangeIntoPairsInACinemaHallTest {

    String seatingArrangement = "AABDECCDBE";

    //Seating arrangement with mismatches not matched.
    //AABC...CD....BD   - 2 swaps. [3 pairs mixed]
       // BCCDBD
          //If you swap 2nd B to front, in one swap all of them are together otherwise you may need more
          // swaps.
    //Question: Can we solve this by solving subproblems? n-1, n-2 etc. It looks like we
    //always to see the entire n inputs. Optimization problem where we cannot solve it for subproblems
    //first.

    //The only operation allowed are swaps? You cannot pull an element from somewhere and insert it somewhere else?
    //There can be some people that are not pairs too.

    //If pulls are allowed, start from elements at the edges and try to match them. Pull their partners out.

    //Solution?: Always
    //AABC...CE    ED ..DB.     [4 pairs mixed - b,c,d,e]
       //AABC...CE...ED...DB
        //BB...CE...ED...DC
        //BB...CC...ED...ED   -3 swaps after next one
    //Question: do the order of swaps matter??
    //If all the unmatched are not completely unmatched, order matters?
    //if BC.....CB.....DE....ED
    //order still doesn't matter the normal algo will still do it in two swaps only.
    //Among say a million users, orders could be spread in groups of 2, 3 or 4 as above. The
    //order doesn't matter because when you swap you will automatically be swapping only within
    //the group??

    //In the worst case, if there are n unmatched pairs, they require n-1 swaps. In each swap
    //one of them paired.
    @Before
    public void setUp() throws Exception {
       seatingArrangement = "AABCFFCEEDDB";

    }

    @After
    public void tearDown() throws Exception {


    }

    @Test
    public void placeLookUpOnceBuiltAlwaysHasTheCorrectplace(){


    }
}