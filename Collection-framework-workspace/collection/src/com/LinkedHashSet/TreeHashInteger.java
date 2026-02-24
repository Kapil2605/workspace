package com.LinkedHashSet;

import java.util.TreeSet;

class Account implements Comparable{
	int id;
	
	Account(int id){
		this.id=id;
	}
	
	@Override
	public int compareTo(Object obj) {
		Account acc=(Account)obj;
		 return Integer.compare(this.id, acc.id);
	}
}



public class TreeHashInteger {

	public static void main(String[] args) {
		Account e1=new Account(12);
		Account e2=new Account(11);
		Account e3=new Account(13);
		Account e4=new Account(10);

		TreeSet<Account>set=new TreeSet<>();
		
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		
		for(Account e:set) {
			System.out.println(e.id);
		}
	}

}
