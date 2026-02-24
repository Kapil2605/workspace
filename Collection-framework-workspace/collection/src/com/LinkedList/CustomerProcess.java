package com.LinkedList;

import java.util.ArrayList;

public class CustomerProcess {

	public static void main(String[] args) {
		ArrayList<CustomerInfo>list=new ArrayList<>();
		
		list.add(new CustomerInfo(1, "Surendra", "surendra@gmail.com"));
		list.add(new CustomerInfo(2, "mahendra", "mahendra@gmail.com"));
		list.add(new CustomerInfo(3, "Kapil", "Kapil@gmail.com"));
		
		for(CustomerInfo c:list) {
			if(c.name.endsWith("ra")) {
				System.out.println(c.name);
			}
		}

	}

}
