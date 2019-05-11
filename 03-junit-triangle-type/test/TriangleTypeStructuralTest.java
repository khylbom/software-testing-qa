/** 
 * A functional test suite for the TriangleType class
 * 
 * @author 			Katelyn Hylbom
 * 
 * Last revised: 	Wednesday November 5, 2018
 */

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Structural tests for TriangleType class
 * 
 * Supplement functional test suite for full code coverage.
 */

@DisplayName("Structural test suite for TriangleType class")
class TriangleTypeStructuralTest {
	
	private static TriangleType test = null;
	
	@BeforeAll
	private static void setUpBeforeClass() {
		test = new TriangleType();
	}
	
	/**
	 * This test case adds coverage to the test suite to test the previously untested
	 * constructor for the TriangleType class.
	 */
	@Test
	void testTriangleTypeConstructor() {
		assertNotEquals(test, null);
	}
	
	/**
	 * This test case fixed a typo in the original test suite from Assignment #2, where I forgot to flip the values when copy/pasting
	 * to generate very similar test inputs but for different combinations of sides under test.
	 * 
	 * Fixes 1 of 6 branches missed for TriangleType, line 24
	 */
	@Test
	void retestInputBeyondUpperBoundSide3() {
		final int expected = 5; //input out of bounds
		int beyondBoundary = 1001, inBoundsA = 999, inBoundsB = 998;
		int result = TriangleType.triangleType(inBoundsA, inBoundsB, beyondBoundary);
		assertEquals(expected, result, TriangleTypeFunctionalTest.constructMessage(inBoundsA, inBoundsB, beyondBoundary, expected, result));
	}
	
	/**
	 * Adds branch coverage for inputs with 2 sides the same, describing invalid triangles.
	 * 
	 * Fixes 1 of 4 branches missed from TriangleType, line 52
	 * Fixes 1 of 4 branches missed from TriangleType, line 54
	 * Fixes 2 of 4 branches missed from TriangleType, line 56
	 */
	@Test
	void testTwoSidesSameInputsInvalidTriangle() {
		final int expected = 4; //not a triangle
		int sameSide = 1, otherSide = 3;	//sameSide+sameSide = 2 < otherSide = 3
		int result1 = TriangleType.triangleType(sameSide, sameSide, otherSide);
		int result2 = TriangleType.triangleType(sameSide, otherSide, sameSide);
		int result3 = TriangleType.triangleType(otherSide, sameSide, sameSide);
		
		assertAll( () -> assertEquals(expected, result1, TriangleTypeFunctionalTest.constructMessage(sameSide, sameSide, otherSide, expected, result1)),
				   () -> assertEquals(expected, result2, TriangleTypeFunctionalTest.constructMessage(sameSide, otherSide, sameSide, expected, result2)),
				   () -> assertEquals(expected, result3, TriangleTypeFunctionalTest.constructMessage(otherSide, sameSide, sameSide, expected, result3)));
	}
	
}
