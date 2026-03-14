package com.kapil;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CalMainTest {
	
	@BeforeAll
	public static void beforeAllTest() {
		System.out.println("Calling before all test case method");
	}
	
	@AfterAll
	public static void afterAllTest() {
		System.out.println("Calling after all test case method");
	}
	
	@BeforeEach
	public  void beforeEachTest() {
		System.out.println("Calling before each test case method");
	}
	@AfterEach
	public  void afterEachTest() {
		System.out.println("Calling after each test case method");
	}
	
	
	@Test
	public void addTwoNumbersTest() {
		int result=CalMain.addTwoNumbers(10, 20);
		
		int actual=30;
		
		assertEquals(actual,result);
		
		System.out.println("Result: "+result);
	}
	
	@Test
	public void addTwoNumbersFirstZeroTest() {
		int result=CalMain.addTwoNumbers(0, 20);
		
		int actual=20;
		
		assertEquals(actual,result);
		System.out.println("Result addTwoNumbersFirstZeroTest: "+result);
	}
	
	
	
	@Disabled
	public void addTwoNumbersBothZeroTest() {
		int result=CalMain.addTwoNumbers(0, 0);
		
		int actual=0;
		
		assertEquals(actual,result);
	}
}
