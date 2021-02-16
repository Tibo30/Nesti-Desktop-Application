package tools;

import junit.framework.TestCase;


public class CheckTest extends TestCase {
	public void testValidPassword() {
		assertEquals(true, Check.isValidPhoneNumber("0603020509"));
	}
	
	public void testValidPassword2() {
		assertEquals(false, Check.isValidPhoneNumber("06030205091"));
	}
	
	public void testValidPassword3() {
		assertEquals(true, Check.isValidPhoneNumber("+33533228696"));
	}

	public void testIsNumeric() {
		assertEquals(true, Check.isNumeric("2.3"));
	}
	
	public void testIsNumeric2() {
		assertEquals(false, Check.isNumeric("dqsdq"));
	}
}
