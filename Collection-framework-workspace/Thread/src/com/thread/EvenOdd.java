package com.thread;

class EvenThread extends Thread{
	
	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			if(i%2==0) {
				System.out.println("Even Thread printing: "+i);
			}
		}
	}
}
class OddThread extends Thread{
	
	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			if(i%2!=0) {
				System.out.println("Odd Thread printing: "+i);
			}
		}
	}
}
public class EvenOdd {

	public static void main(String[] args) {
		EvenThread even =new EvenThread();
		even.start();
		OddThread odd=new OddThread();
		odd.start();
	}

}
