package com.paxovision.conceptual;


import java.util.ArrayList;

/**
 * Created by shawon on 3/21/16.
 */
public class JavaArrayLists {

    public static void main (String [] args){

        //example of arrayList in Java:

        ArrayList<String> myGroceryList = new ArrayList<String>();
        myGroceryList.add("Milk");
        myGroceryList.add("Butter");
        myGroceryList.add("Bread");
        myGroceryList.add("Misc_Items");

        //System.out.println("The Array List contains the following Items \n"  + myGroceryList);

       String item = myGroceryList.get(3);
        //System.out.println(item);

        //looping

        for (int i = 0; i < myGroceryList.size(); i++){
            System.out.println("Index: " + i + " Item: " + myGroceryList.get(i));
        }




    }
}
