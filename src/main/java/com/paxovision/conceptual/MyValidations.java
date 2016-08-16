package com.paxovision.conceptual;



/**
 * Created by shawon on 4/9/16.
 */
public class MyValidations {

    public static void HasValidation() throws Exception{

        String myValue = "MyValue";

        if (myValue.contains(myValue)){
            System.out.println("Validations Pass");
        }else{
            System.out.println("Validations fail");
        }
    }




}
