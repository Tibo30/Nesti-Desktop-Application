package tools;

import org.junit.Test;

import junit.framework.TestCase;


public class CheckTest extends TestCase {
	
	
	@Test
	public void testValidPhoneNumber() {
		assertFalse(Check.isValidPhoneNumber("06030205091"));
		assertTrue(Check.isValidPhoneNumber("+33533228696"));
		assertTrue(Check.isValidPhoneNumber("0603020509"));
		//ajouter des cas : vide, avec caractères, null, lettre , si + n'est pas au début, si c'est moins/plus 10 chiffres
	}
	
	@Test
	public void testIsNumeric() {
		assertTrue(Check.isNumeric("2.3"));
		assertFalse(Check.isNumeric("dqsdq"));
	}
	

	
	@Test
	public void testIsValidName() {
		
		assertTrue(Check.isValidName("Pierre-André"));
		assertFalse(Check.isValidName("Pierre& André"));
		
	}
	
	@Test
	public void testIsValidPsw() {
		
		assertFalse(Check.isValidPsw("Df@125test=&@htyt".toCharArray()));
		assertFalse(Check.isValidPsw("145gh".toCharArray()));
		assertFalse(Check.isValidPsw("SfGt2021".toCharArray()));
		assertFalse(Check.isValidPsw("1584&2021".toCharArray()));
		assertFalse(Check.isValidPsw("&@ù@@@@@======".toCharArray()));
		assertTrue(Check.isValidPsw("Df@125test".toCharArray()));
		assertFalse(Check.isValidPsw("".toCharArray()));
		assertFalse(Check.isValidPsw("ggrlmpus".toCharArray()));
		assertTrue(Check.isValidPsw("EDf@125test@".toCharArray()));



		
	}

	
	
	
}
