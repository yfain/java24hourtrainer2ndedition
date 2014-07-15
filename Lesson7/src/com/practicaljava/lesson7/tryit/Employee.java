package com.practicaljava.lesson7.tryit;

public class Employee implements Payable{
       private String name;

       public Employee(String name){
              this.name=name;
       }

       public boolean increasePay(int percent) {
         System.out.println("Increasing salary by " + percent
             + "%: " + name);
         return true;
       }
}