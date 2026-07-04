package com.kodewala;

class Singleton {

    private static Singleton instance;

    // Private constructor prevents direct instantiation
    private Singleton() {}

    // Global access point
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    
    public static synchronized Singleton getInstance1() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
public class BaseClass{
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();

		System.out.println(s1 == s2); // true
	}
}