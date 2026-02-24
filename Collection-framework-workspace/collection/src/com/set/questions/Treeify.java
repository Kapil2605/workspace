package com.set.questions;

import java.util.HashSet;
class Key{
	int id;
	
	Key(int id){
		this.id=id;
	}
	@Override
	public int hashCode() {
		return 1;
	}
	@Override
	public boolean equals(Object obj) {
		Key k=(Key)obj;
		return this.id==k.id;
	}
}
public class Treeify {

	public static void main(String[] args) {
		HashSet<Key>set=new HashSet<>(64);
		
		for(int i=0;i<=10;i++) {
			set.add(new Key(i));
		}
	
	}

}
