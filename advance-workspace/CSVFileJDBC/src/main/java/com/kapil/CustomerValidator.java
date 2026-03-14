package com.kapil;

public class CustomerValidator {

    public static String validate(String[] data) {

        String Customer_ID = data[0];
        String First_Name = data[1];
        String Last_Name = data[2];
        String Email = data[3];
        String Phone = data[4];
        String City = data[5];
        String State = data[6];
        String Country = data[7];
        String Status = data[9];

        if (Customer_ID == null || Customer_ID.trim().isEmpty() || !Customer_ID.matches("\\d+")) {
            return "Invalid Customer ID";
        }

        if (First_Name == null || First_Name.trim().isEmpty()
                || Last_Name == null || Last_Name.trim().isEmpty()
                || !First_Name.matches("[a-zA-Z]+")
                || !Last_Name.matches("[a-zA-Z]+")) {

            return "Invalid Name";
        }

        if (Email == null || Email.trim().isEmpty()
                || !Email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {

            return "Invalid Email";
        }

        if (Phone == null || Phone.trim().isEmpty() || Phone.startsWith("91-") || Phone.length() < 10) {
            return "Invalid Phone";
        }

        if (City == null || City.trim().isEmpty()
                || State == null || State.trim().isEmpty()
                || Country == null || Country.trim().isEmpty()) {

            return "Invalid Address";
        }

        if (Status == null || Status.trim().isEmpty()) {
            return "Invalid Status";
        }

        return "VALID";
    }
}