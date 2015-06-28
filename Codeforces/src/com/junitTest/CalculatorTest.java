package com.junitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorTest {
	private static Calculator calculator = new Calculator();
	@Before
	public void setUp() throws Exception {
		calculator.clear();
	}

	@Test
	public void testAdd() {
		calculator.add(2);
		calculator.add(3);
		assertEquals(5, calculator.getResult());
	}

	@Test
	public void testSub() {
		calculator.add(10);
		calculator.sub(3);
		assertEquals(7, calculator.getResult());
	}

	@Ignore
	public void testMul() {
		
	}

	@Test
	public void testDiv() {
		calculator.add(10);
		calculator.div(2);
		assertEquals(5, calculator.getResult());
	}
	
	@Test(timeout=2000)
	public void testFor(){
		calculator.squareRoot(2);
		
	}
	
	@Test(expected=ArithmeticException.class)      //期望抛出异常
	public void testDivBy0(){
		calculator.add(2);
		calculator.div(0);
	}
}
