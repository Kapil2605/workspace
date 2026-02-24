package com.hotelBooking;

class Hotel{
	private int availableSeats = 5;
	
	//syncronized method
	public synchronized void bookSeat(String customerName,int seats) {
		System.out.println(customerName + " trying to book " + seats + " seat(s)");

        if (availableSeats >= seats) {
            System.out.println(customerName + " booking confirmed ✅");

            availableSeats = availableSeats - seats;

            System.out.println("Seats left: " + availableSeats);
        } else {
            System.out.println(customerName + " booking failed ❌ Not enough seats");
        }

        System.out.println("--------------------------------");
	}
}

class CustomerThread extends Thread{
	Hotel hotel;
	String customerName;
	int seats;
	
	CustomerThread(Hotel hotel, String customerName, int seats) {
        this.hotel = hotel;
        this.customerName = customerName;
        this.seats = seats;
    }

    @Override
    public void run() {
        hotel.bookSeat(customerName, seats);
    }
    
}

public class HotelBookingApp {

	public static void main(String[] args) {
		 Hotel hotel = new Hotel(); // one shared object

	        CustomerThread t1 = new CustomerThread(hotel, "Kapil", 2);
	        CustomerThread t2 = new CustomerThread(hotel, "Amit", 2);
	        CustomerThread t3 = new CustomerThread(hotel, "Rohit", 2);

	        t1.start();
	        t2.start();
	        t3.start();

	}

}
