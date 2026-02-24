package com.set;

import java.util.ArrayList;
import java.util.HashSet;

class Products{
	String name;

	Products(String _name){
		this.name=_name;
	}
	
	@Override
	public int hashCode() {
		return 23456789;
	}
}
public class HashCollision {

	public static void main(String[] args) {
		Products p1=new Products("Samsung");
		Products p2=new Products("Iphone");
		Products p3=new Products("One Plus");
		
//		System.out.println(p1.equals(p2));
//		System.out.println(p1.hashCode()+" "+p2.hashCode());
//		System.out.println(p1.equals(p3));
//		System.out.println(p1.hashCode()+" "+p3.hashCode());
		
		HashSet<Products>set=new HashSet<>();
		
		set.add(p1);
		set.add(p2);
		set.add(p3);
		
		for (Products p:set) {
			int hashCode = p.hashCode();
            int hash = hashCode ^(hashCode >>> 16);
            int bucketIndex=(16-1)&hash;
            
            System.out.println("hascode: "+hashCode);
            System.out.println("hash: "+hash);
			System.out.println("Bucket index: "+bucketIndex);
			System.out.println(p.name);
			System.out.println("---------------------------");
		}
		

	}

}
