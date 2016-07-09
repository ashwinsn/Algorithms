package com.ashcode.app.Threads;

import java.util.ArrayList;

/**
 * Created by anatarajan on 4/27/16.
 */
//They eat or think. They need 2 chopsticks to eat. The order in which they take chopsticks decide if they have a deadlock or not.
//If you say philosophers can pick up their chopsticks in random order or in a left right order, there will always be deadlock. If they
//can pick up the chopsticks such that the lowest numbered one assigned to them is always picked first, then they wont have a problem.


public class DiningPhilosopher implements Runnable{

    ChopStick leftChopStick;
    ChopStick rightChopStick;
    GetChopSticks chopStickPickOrder;

    public DiningPhilosopher(ChopStick one, ChopStick two, GetChopSticks chopStickPickOrder){
        this.leftChopStick = one;
        this.rightChopStick = two;
        this.chopStickPickOrder = chopStickPickOrder;
    }

    public void eat() throws InterruptedException {
        ArrayList<ChopStick> chopSticks =  chopStickPickOrder.getChopSticks(leftChopStick, rightChopStick);
        Thread.sleep(3000);
    }

    public void think() throws InterruptedException {
        Thread.sleep(5000);
    }

    public void run(){
        while(true){
            try {
                eat();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

            }
        }
    }

}
