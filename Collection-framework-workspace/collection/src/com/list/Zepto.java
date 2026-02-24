package com.list;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;

public class Zepto {
	String name;
	String deliveryBoyName;
	LocalTime pickupTime;
	LocalTime deliveredTime;
	
	
	public Zepto(String name, String deliveryBoyName, LocalTime pickupTime, LocalTime deliveredTime) {
		super();
		this.name = name;
		this.deliveryBoyName = deliveryBoyName;
		this.pickupTime = pickupTime;
		this.deliveredTime = deliveredTime;
	}
	
	public boolean isFastDelivery() {
		 long minutes = Math.abs(Duration.between(pickupTime, deliveredTime).toMinutes());
		 	//System.out.println(minutes);
	        return minutes < 10;
	}
	
	public void printDelieveredIfFast() {
		if(isFastDelivery()) {
			System.out.println(deliveryBoyName);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Zepto>list=new ArrayList<>();
		list.add(new Zepto("Kapil","Rohit",LocalTime.of(21, 45),LocalTime.of(21, 50)));
		list.add(new Zepto("Gaurav","Amit",LocalTime.of(11,05),LocalTime.of(11, 50)));
		list.add(new Zepto("Kapil","Jay",LocalTime.of(12, 45),LocalTime.of(12, 40)));
		
		for(Zepto z:list) {
			z.printDelieveredIfFast();
		}
	}
}
