package com.practicalJava.lesson15.payincrease;

@FunctionalInterface
public interface Payable {
    int INCREASE_CAP = 20; 
	boolean increasePay(int percent);
}
