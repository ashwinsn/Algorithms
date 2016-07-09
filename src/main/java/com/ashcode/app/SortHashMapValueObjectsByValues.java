package com.ashcode.app;

import java.util.*;

/**
 * Created by anatarajan on 3/5/16.
 */
public class SortHashMapValueObjectsByValues {
    HashMap<String, Person> myHashMap = new HashMap();

    public void addValues(){
        String name1 = "ashwin";
        myHashMap.put(name1, new Person(name1, 36));

        String name2 = "Sri";
        myHashMap.put(name2, new Person(name2, 33));

        String name3 = "kutty";
        myHashMap.put(name3, new Person(name3, 0));

    }

    public void sortBasedOnAgeUsingTreeSet(){
        SortedSet<Map.Entry<String, Person>> sortedSet = new TreeSet<Map.Entry<String, Person>>(
                new Comparator<Map.Entry<String,Person>>(){
                    public int compare(Map.Entry<String, Person> entry1, Map.Entry<String, Person> entry2){
                        return entry1.getValue().getAge() - entry2.getValue().getAge();
                    }
                });

        sortedSet.addAll(myHashMap.entrySet());
        System.out.println(sortedSet);
    }

    public void sortBasedonAgeUsingArrayList(){
        ArrayList<Person> sortedList = new ArrayList<Person>();
        sortedList.addAll(myHashMap.values());

        Collections.sort(sortedList, new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.age - o1.age;
            }
        });

        for(Person person : sortedList){
            System.out.print(person.getAge() + ",");
        }
    }

    public static void main(String args[]){
        SortHashMapValueObjectsByValues sortHashMapValueObjectsByValues = new SortHashMapValueObjectsByValues();
        sortHashMapValueObjectsByValues.addValues();

        sortHashMapValueObjectsByValues.sortBasedOnAgeUsingTreeSet();
        sortHashMapValueObjectsByValues.sortBasedonAgeUsingArrayList();
    }
}
