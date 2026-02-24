package com.encapsulation;

public class BankAccount {
	private int balance;
	private int pin;
	private double accountNo;
	
	public void deposit(double accountNo,int amount){
		System.out.println("iniital balance:" +balance);
		balance+=amount;
		System.out.println("Balance after deposit: "+balance);
	}
	public void withdraw(double accountNo,int amount) {
		if(balance>amount) {
			System.out.println("Processing balance withdrawl");
			balance-=amount;
			System.out.println("Balance after withdrwal: "+balance);
		}
		else {
			System.out.println("Insufficient balance");
		}
	}
	
	public static void main(String[] args) {
		BankAccount obj=new BankAccount();
		obj.deposit(1234567890, 2000);
		obj.withdraw(1234567890, 1000);
		obj.withdraw(1234567890, 2000);
	}
}
