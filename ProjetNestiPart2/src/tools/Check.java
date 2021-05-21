package tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
	
	public static boolean isValidPhoneNumber(String number) {
		// Regex to check valid phone number.
				String regex = "^(0|\\+33)[1-9]([-. ]?[0-9]{2}){4}$";
				// Compile the ReGex
				Pattern p = Pattern.compile(regex);
				// If the phone number is empty
				// return false
				if (number == null) {
					return false;
				}
				// Pattern class contains matcher() method
				// to find matching between given phone number
				// and regular expression.
				Matcher m = p.matcher(number);
				// Return if the phone number
				// matched the ReGex
				return m.matches();
	}
	
	public static boolean isNumeric(String str) {
		boolean numeric = false;
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			
		}
		return numeric;
	}

}
