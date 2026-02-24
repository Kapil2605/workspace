package com.list;

public class StringBuilderExample {
public static void main(String[] args) {
	
	StringBuffer obj=new StringBuffer("SELECT * FROM CUSTOMER");
	System.out.println(obj);
	
	obj.insert(1," WHERE ID=12");
	System.out.println(obj);
	
	obj.append(" AND ADDRESS=DELHI");
	System.out.println(obj);
}
}
