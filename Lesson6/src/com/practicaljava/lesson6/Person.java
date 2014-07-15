package com.practicaljava.lesson6;

public class Person {
	private String name;
	
	public Person(String name){
		this.name=name;
	}

	public String getName(){
		return "Person's name is " + name; 
	}
}
