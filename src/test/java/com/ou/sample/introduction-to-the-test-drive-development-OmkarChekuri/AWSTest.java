package com.ou.sample.introduction_to_the_test_drive_development_OmkarChekuri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AWSTest {
	
	private static final int FILLER_VALUE = Integer.MIN_VALUE;
	private int[] original={1, 2, 3};
	AWS originalAWS;


	
	@BeforeEach
	void setUp() throws Exception {
		 originalAWS = new AWS(this.original);
	}
	
//	@Test
//	void testGetValues() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSetValues() {
//		fail("Not yet implemented");
//     }
//
//	@T/est
//	void testToString() {
//		fail("Not yet implemented");
//	}

	@Test
	void testAWS() {
		int[] expected = {1, 2, 3};
		int[] x = {1, 2, 3};
		AWS aws = new AWS(x);
		
		//int[] actual = aws.getValues();
		
		//System.out.println(actual[1]);
		
		x[1] = 100;
		
		int[] actual = aws.getValues();
		
		//System.out.println(actual[1]);
		
		assertEquals(actual[0], expected[0]);
		assertEquals(actual[1], expected[1]);
		//assertEquals(actual[0], x[0]);
		//assertEquals(actual[1], x[1]);
	}
	
	@Test
	void testRemove() {
		int[] x = {1, 2, 3};
		AWS aws = new AWS(x);
		
		int value = aws.remove(-1);
		//System.out.println(value);
		
		int expected = FILLER_VALUE;
		//System.out.println(expected);

		assertEquals(expected, value);
		
		value = aws.remove(x.length + 10);
		expected = FILLER_VALUE;
		assertEquals(expected, value);
		
		value = aws.remove(0);
		assertEquals(x[0], value);
		
		int[] r = aws.getValues();
		value = r[r.length - 1];
		assertEquals(expected, value);
		
		value = aws.remove(2);
		assertEquals(r[2], value);
		
		r = aws.getValues();
		value = r[r.length - 1];
		assertEquals(expected, value);
		
	}
	
	@Test
	void testFillAndExpand() {
		int position = 1;
		int numberOfTimes = 2;
		int[] org = originalAWS.getValues();
		int expectedValue = org[position];
		int first = org[0];
 		
		int expected = originalAWS.getValues().length + numberOfTimes;
		originalAWS.fillAndExpand(position, numberOfTimes);
		int[] result = originalAWS.getValues();
		assertEquals(expected, result.length);
		
		int a = result[1];
		int b = result[2];
		int c = result[3];
		assertEquals(expectedValue, a);
		assertEquals(expectedValue, b);
		assertEquals(expectedValue, c);
		assertEquals(first, result[0]);
		 
		
	
	}
//	@Test
//	void testFillAndExpandWithNegative() {
//		int position = 1;
//		int numberOfTimes = -2;
//		
//		int[] org = originalAWS.getValues();
//		int expectedValue = org[position];
// 		int first = org[0];
//		int expected = originalAWS.getValues().length + numberOfTimes;
//		originalAWS.fillAndExpand(position, numberOfTimes);
//		int[] result = originalAWS.getValues();
//		a/ssertEquals(expected, result.length);
//		
//		int a = result[1];
//		int b = result[2];
//		int c = result[3];
//		assertEquals(expectedValue, a);
//		assertEquals(expectedValue, b);
//		assertEquals(expectedValue, c);
//		 
//		assertEquals(first, result[0]); 
//
//	
//	}
	
	@Test
	void testDoubleTheElements() {

		int[] org = originalAWS.getValues();

		originalAWS.doubleTheElements();

		int[] result = originalAWS.getValues();

		int[] expected = {2, 4, 6};

		assertEquals(expected[0], result[0]);
		assertEquals(expected[0], result[0]);
		assertEquals(expected[0], result[0]);

	}
	
	@Test 
	void testRemoveBiggerThan() {
		
		int[] org = originalAWS.getValues();
		
		int threshold = 2;
		
		int remainingElements = originalAWS.removeBiggerThan(threshold);
		
		assertEquals(remainingElements, 1);
		
		int[] result = originalAWS.getValues();
		
		int[] expected = {1, 2, FILLER_VALUE};
		
		
		assertEquals(expected[0], result[0]);
		assertEquals(expected[1], result[1]);
		assertEquals(FILLER_VALUE, result[2]);
		
		
	}
	
	@Test
	void testStepMultiplier()
	{
		
		int[] original = {0,5,15,25,50,75,110};
		int[] expected = {0,10,60,2500,5000,7500,110};
		
		AWS aws = new AWS(original);
		
		int[] result = aws.stepMultiplier();
			
		assertEquals(expected[0], result[0]);
		assertEquals(expected[1], result[1]);
		assertEquals(expected[2], result[2]);
		assertEquals(expected[3], result[3]);
		assertEquals(expected[4], result[4]);
		assertEquals(expected[5], result[5]);
		assertEquals(expected[6], result[6]);
						
	}
	
	
	
	
	

}
