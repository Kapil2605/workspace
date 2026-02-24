package com.set.questions;

import java.util.HashSet;

class City {

    String name;

    City(String name) {
        this.name = name;
    }

    // Important for HashSet
    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        City city = (City) obj;
        return name.equals(city.name);
    }
}

public class RehashingExample {

    public static void main(String[] args) {

        HashSet<City> set = new HashSet<>(16,0.50f);

        // Creating 12 City objects
        set.add(new City("Delhi"));
        set.add(new City("Mumbai"));
        set.add(new City("Chennai"));
        set.add(new City("Kolkata"));
        set.add(new City("Bangalore"));
        set.add(new City("Hyderabad"));
        set.add(new City("Pune"));
        set.add(new City("Jaipur"));
        set.add(new City("Ahmedabad"));
        set.add(new City("Noida"));
        set.add(new City("Gurgaon"));
        set.add(new City("Faridabad"));
        

        System.out.println("Total cities in HashSet: " + set.size());

//        for (City c : set) {
//            System.out.println(c.name);
//        }
//        
        for(City s:set) {
			 	 int hashCode = s.hashCode();
				 int hash = hashCode ^ (hashCode >>> 16);
				 int bucketIndex=(32 - 1) & hash;
				 System.out.println("Bucket index: "+bucketIndex+ " "+s.name);
				 
		}
        
        System.out.println("After rehashing:  .................");
        
        set.add(new City("Rewari"));
        set.add(new City("Narnaul"));
        set.add(new City("Mahedergarh"));
        set.add(new City("jind"));
        set.add(new City("Gurugram"));
        set.add(new City("delhi"));
        
        for(City s:set) {
			 int hashCode = s.hashCode();
				 int hash = hashCode ^ (hashCode >>> 16);
				 int bucketIndex=(32 - 1) & hash;
				 System.out.println("Bucket index: "+bucketIndex+" "+s.name);
				 
		}
        
    }
}
