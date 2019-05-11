/** 
 * A functional test suite for the TriangleType class
 * 
 * @author 			Katelyn Hylbom
 * 
 * Last revised: 	Monday October 29, 2018
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Functional tests for TriangleType class
 * 
 * Given the lengths of 3 sides of a triangle,
 * determine the type of triangle.
 */

@DisplayName("Functional test suite for TriangleType class")
class TriangleTypeFunctionalTest {

	private static final int SCALENE = 1;
	private static final int ISOSCELES = 2;
	private static final int EQUILATERAL = 3;
	private static final int NOT_A_TRIANGLE = 4;
	private static final int INPUT_OUT_OF_BOUNDS = 5;
	
	private int side1, side2, side3;

	private static final String translateTriangleType(int result) {
		switch(result) {
		case SCALENE: { return "scalene"; }
		case ISOSCELES: { return "isosceles"; }
		case EQUILATERAL: { return "equilateral"; }
		case NOT_A_TRIANGLE: { return "not a triangle"; }
		case INPUT_OUT_OF_BOUNDS: { return "input out of bounds"; }
		default: { return "unknown error"; }
		}
	}
	
	public static String constructMessage(int side1, int side2, int side3, int expected, int actual) {
		return String.format("input: (%d, %d, %d), expected: %s, actual: %s", 
				side1, side2, side3, translateTriangleType(expected), translateTriangleType(actual));
	}
	
	public static String constructMessageNotEquals(int side1, int side2, int side3, int expected, int actual) {
		return String.format("input: (%d, %d, %d), expected: NOT %s, actual: %s", 
				side1, side2, side3, translateTriangleType(expected), translateTriangleType(actual));
	}

	@Test
	@DisplayName("TC-01.1 Out of bounds: Input negative Side1")
	void testInputIsNegativeSide1() {
		side1 = -1; //out of bounds
		side2 = 2;
		side3 = 3;
		int result = TriangleType.triangleType(side1, side2, side3);
		assertEquals(INPUT_OUT_OF_BOUNDS, result, constructMessage(side1, side2, side3, INPUT_OUT_OF_BOUNDS, result));
	}
	
	@Test
	@DisplayName("TC-01.2 Out of bounds: Input zero Side1")
	void testInputIsZeroSide1() {
		side1 = 0; //out of bounds
		side2 = 2;
		side3 = 3;
		int result = TriangleType.triangleType(side1, side2, side3);
		assertEquals(INPUT_OUT_OF_BOUNDS, result, constructMessage(side1, side2, side3, INPUT_OUT_OF_BOUNDS, result));
	}
	
	@Test
	@DisplayName("TC-02.1 Out of bounds: Input negative Side2")
	void testInputIsNegativeSide2() {
		side1 = 2;
		side2 = -1; //out of bounds
		side3 = 3;
		int result = TriangleType.triangleType(side1, side2, side3);
		assertEquals(INPUT_OUT_OF_BOUNDS, result, constructMessage(side1, side2, side3, INPUT_OUT_OF_BOUNDS, result));
	}
	
	@Test
	@DisplayName("TC-02.2 Out of bounds: Input zero Side2")
	void testInputIsZeroSide2() {
		side1 = 2;
		side2 = 0; //out of bounds
		side3 = 3;
		int result = TriangleType.triangleType(side1, side2, side3);
		assertEquals(INPUT_OUT_OF_BOUNDS, result, constructMessage(side1, side2, side3, INPUT_OUT_OF_BOUNDS, result));
	}
	
	@Test
	@DisplayName("TC-03.1 Out of bounds: Input negative Side3")
	void testInputIsNegativeSide3() {
		side1 = 2;
		side2 = 3;
		side3 = -1; //out of bounds
		int result = TriangleType.triangleType(side1, side2, side3);
		assertEquals(INPUT_OUT_OF_BOUNDS, result, constructMessage(side1, side2, side3, INPUT_OUT_OF_BOUNDS, result));
	}
	
	@Test
	@DisplayName("TC-03.2 Out of bounds: Input zero Side3")
	void testInputIsZeroSide3() {
		side1 = 2;
		side2 = 3;
		side3 = 0; //out of bounds
		int result = TriangleType.triangleType(side1, side2, side3);
		assertEquals(INPUT_OUT_OF_BOUNDS, result, constructMessage(side1, side2, side3, INPUT_OUT_OF_BOUNDS, result));
	}
	
	@Test
	@DisplayName("TC-04.1 Out of bounds: Input above upper bound Side1")
	void testInputIsAboveUpperBoundSide1() {
		side1 = 1001; //line 24: branch 1
		side2 = 999;
		side3 = 1000;
		int result = TriangleType.triangleType(side1, side2, side3);
		assertEquals(INPUT_OUT_OF_BOUNDS, result, constructMessage(side1, side2, side3, INPUT_OUT_OF_BOUNDS, result));
	}
	
	@Test
	@DisplayName("TC-04.2 Out of bounds: Input on upper bound Side1")
	void testInputIsOnUpperBoundSide1() {
		side1 = 1000;
		side2 = 998;
		side3 = 999;
		int result = TriangleType.triangleType(side1, side2, side3);
		assertNotEquals(INPUT_OUT_OF_BOUNDS, result, constructMessageNotEquals(side1, side2, side3, INPUT_OUT_OF_BOUNDS, result));
	}
	
	@Test
	@DisplayName("TC-05.1 Out of bounds: Input above upper bound Side2")
	void testInputIsAboveUpperBoundSide2() {
		side1 = 999;
		side2 = 1001;
		side3 = 1000;
		int result = TriangleType.triangleType(side1, side2, side3);
		assertEquals(INPUT_OUT_OF_BOUNDS, result, constructMessage(side1, side2, side3, INPUT_OUT_OF_BOUNDS, result));
	}
	
	@Test
	@DisplayName("TC-05.2 Out of bounds: Input on upper bound Side2")
	void testInputIsOnUpperBoundSide2() {
		side1 = 999;
		side2 = 1000;
		side3 = 998;
		int result = TriangleType.triangleType(side1, side2, side3);
		assertNotEquals(INPUT_OUT_OF_BOUNDS, result, constructMessageNotEquals(side1, side2, side3, INPUT_OUT_OF_BOUNDS, result));
	}
	
	@Test
	@DisplayName("TC-06.1 Out of bounds: Input above upper bound Side3")
	void testInputIsAboveUpperBoundSide3() {
		side1 = 999;
		side2 = 1001;
		side3 = 1000;
		int result = TriangleType.triangleType(side1, side2, side3);
		assertEquals(INPUT_OUT_OF_BOUNDS, result, constructMessage(side1, side2, side3, INPUT_OUT_OF_BOUNDS, result));
	}
	
	@Test
	@DisplayName("TC-06.2 Out of bounds: Input on upper bound Side3")
	void testInputIsOnUpperBoundSide3() {
		side1 = 998;
		side2 = 999;
		side3 = 1000;
		int result = TriangleType.triangleType(side1, side2, side3);
		assertNotEquals(INPUT_OUT_OF_BOUNDS, result, constructMessageNotEquals(side1, side2, side3, INPUT_OUT_OF_BOUNDS, result));
	}
	
	@Test
	@DisplayName("TC-07.1 Not a triangle: Longest side equal to sum others, Side1 longest")
	void TestNotATriangle_LongestEqualToSumOthers_Side1() {
		side1 = 5; //longest side
		side2 = 2;
		side3 = 3;
		int result = TriangleType.triangleType(side1, side2, side3);
		assertEquals(NOT_A_TRIANGLE, result, constructMessage(side1, side2, side3, NOT_A_TRIANGLE, result));
	}
	
	@Test
	@DisplayName("TC-07.2 Not a triangle: Longest side greater than sum others, Side1 longest")
	void TestNotATriangle_LongestGreaterThanSumOthers_Side1() {
		side1 = 5; //longest side
		side2 = 1;
		side3 = 2;
		int result = TriangleType.triangleType(side1, side2, side3);
		assertEquals(NOT_A_TRIANGLE, result, constructMessage(side1, side2, side3, NOT_A_TRIANGLE, result));
	}
	
	@Test
	@DisplayName("TC-08.1 Not a triangle: Longest equal to sum other, Side2 longest")
	void TestNotATriangle_LongestEqualToSumOthers_Side2() {
		side1 = 2;
		side2 = 5; //longest side
		side3 = 3;
		int result = TriangleType.triangleType(side1, side2, side3);
		assertEquals(NOT_A_TRIANGLE, result, constructMessage(side1, side2, side3, NOT_A_TRIANGLE, result));
	}
	
	@Test
	@DisplayName("TC-08.2 Not a triangle: Longest greater than sum others, Side2 longest")
	void TestNotATriangle_LongestGreaterThanSumOthers_Side2() {
		side1 = 1;
		side2 = 5; //longest side
		side3 = 2;
		int result = TriangleType.triangleType(side1, side2, side3);
		assertEquals(NOT_A_TRIANGLE, result, constructMessage(side1, side2, side3, NOT_A_TRIANGLE, result));
	}
	
	@Test
	@DisplayName("TC-09.1 Not a triangle: Longest equal to sum other, Side3 longest")
	void TestNotATriangle_LongestEqualToSumOthers_Side3() {
		side1 = 2;
		side2 = 3;
		side3 = 5; //longest side
		int result = TriangleType.triangleType(side1, side2, side3);
		assertEquals(NOT_A_TRIANGLE, result, constructMessage(side1, side2, side3, NOT_A_TRIANGLE, result));
	}
	
	@Test
	@DisplayName("TC-09.2 Not a triangle: Longest greater than sum others, Side3 longest")
	void TestNotATriangle_LongestGreaterThanSumOthers_Side3() {
		side1 = 1;
		side2 = 2;
		side3 = 5; //longest side
		int result = TriangleType.triangleType(side1, side2, side3);
		assertEquals(NOT_A_TRIANGLE, result, constructMessage(side1, side2, side3, NOT_A_TRIANGLE, result));
	}
	
	@Test
	@DisplayName("TC-10.1 Triangle type equilateral") 
	void TestEquilateral_AllSidesSame() {
		side1 = side2 = side3 = 2; //all sides same
		int result = TriangleType.triangleType(side1, side2, side3);
		assertEquals(EQUILATERAL, result, constructMessage(side1, side2, side3, EQUILATERAL, result));
	}
	
	@Test
	@DisplayName("TC-11.1 Triangle type isosceles: Side1 equal to Side2")
	void TestIsosceles_Side1And2Equal() {
		side1 = side2 = 2;
		side3 = 3;
		int result = TriangleType.triangleType(side1, side2, side3);
		assertEquals(ISOSCELES, result, constructMessage(side1, side2, side3, ISOSCELES, result));
	}
	@Test
	@DisplayName("TC-11.2 Triangle type isosceles: Side1 equal to Side3")
	void TestIsosceles_Side1And3Equal() {
		side1 = side3 = 2;
		side2 = 3;
		int result = TriangleType.triangleType(side1, side2, side3);
		assertEquals(ISOSCELES, result, constructMessage(side1, side2, side3, ISOSCELES, result));
	}
	
	@Test
	@DisplayName("TC-11.3 Triangle type isosceles: Side2 equal to Side3")
	void TestIsosceles_Side2And3Equal() {
		side2 = side3 = 2;
		side1 = 3;
		int result = TriangleType.triangleType(side1, side2, side3);
		assertEquals(ISOSCELES, result, constructMessage(side1, side2, side3, ISOSCELES, result));
	}
	
	@Test
	@DisplayName("TC-12.1 Triangle type scalene: All sides different")
	void TestScalene_AllSidesDifferent() {
		side1 = 3;
		side2 = 4;
		side3 = 5;
		int result = TriangleType.triangleType(side1, side2, side3);
		assertEquals(SCALENE, result, constructMessage(side1, side2, side3, SCALENE, result));
	}

}
