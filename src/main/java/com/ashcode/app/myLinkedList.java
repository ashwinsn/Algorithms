package com.ashcode.app;

public class myLinkedList {

    Node head;


    public myLinkedList(Node head){
       this.head = head;
    }

    public void add(Node newNode){
        Node currNode = head;

        if(head == null){
            head = newNode;
            return;
        }

        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public Node reverse(Node currentHead){
        Node newHead = null;
        if(currentHead.next != null){
            newHead = reverse(currentHead.next);
            currentHead.next.next = currentHead;
        } else {
            newHead = currentHead;
        }
        head = newHead;
        return newHead;
    }

    public Node getHead(){
        return head;
    }

};