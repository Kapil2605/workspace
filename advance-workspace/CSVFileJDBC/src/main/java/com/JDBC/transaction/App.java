package com.JDBC.transaction;

public class App 
{
    public static void main( String[] args )
    {
       FundTransfer ft=new FundTransfer();
       ft.doFundTransfer(1002,1003, 100);
    }
}
