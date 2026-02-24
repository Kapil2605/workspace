package com.set.questions;

import java.util.HashSet;

class Zepto{
	String orderId;
	String productName;
	
	
	Zepto(String orderId,String productName){
		this.orderId=orderId;
		this.productName=productName;
	}
	
	@Override
	public boolean equals(Object obj) {
		Zepto z=(Zepto)obj;
		return this.productName.equals(z.productName) & this.orderId.equals(z.orderId);
	}
	
	@Override
	public int hashCode() {
		return productName.hashCode() +orderId.hashCode();
	}
}
public class HashCodeAndEquals {

	public static void main(String[] args) {
		
		Zepto z1=new Zepto("RA001","Apple");
		Zepto z2=new Zepto("RA001","Apple");
		
		HashSet<Zepto>set=new HashSet<>();
		set.add(z1);
		set.add(z2);
		
		System.out.println(z1.equals(z2));
		System.out.println(z1.hashCode()+" "+z2.hashCode());
		System.out.println();
		System.out.println(set);

	}

}
