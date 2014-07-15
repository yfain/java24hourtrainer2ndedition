package com.practicaljava.lesson7;

public class Contractor extends Person {

       public Contractor(String name){
              super(name);
       }
       public boolean increasePay(int percent) {
              if(percent < INCREASE_CAP){
                 System.out.println("Increasing hourly rate by " +
                                     percent + "%. "+ getName());
                return true;
             } else {
                System.out.println("Sorry, can't increase hourly rate by more than " +
                                 INCREASE_CAP + "%. "+ getName());
                
                return false;
             }
       }
}