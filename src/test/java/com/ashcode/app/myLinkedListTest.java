package com.ashcode.app;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by anatarajan on 11/15/15.
 */

public class myLinkedListTest {

    myLinkedList list;
    Node someNode;
    Node anotherNode;
    Node oneMoreNode;

    @Before
    public void Setup(){
        someNode  = new Node(10, null);
        anotherNode = new Node(11, null);
        oneMoreNode = new Node(12, null);

        list = new myLinkedList(someNode);
        list.add(anotherNode);
        list.add(oneMoreNode);
    }

    @Test
    public void reverseReversesTheList(){
       list.reverse(list.getHead());
        Node currNode = list.getHead();
        assertThat(currNode, equalTo(oneMoreNode));
        assertThat(currNode.next, equalTo(anotherNode));
        assertThat(currNode.next.next, equalTo(someNode));
    }


    @Test
    public void reverseReturnsTheHeadofTheNewList(){
        Node newHead = list.reverse(list.getHead());
        assertThat(newHead,equalTo(oneMoreNode));
    }

    @Test
    public void returnKthNodeFromTailReturnsTheKthNodeWhenKisPositive(){

    }

    @Test
    public void returnsKthNodeFromTailReturnsNullWhenKisNegative(){

    }

}