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
	
	//Function to check login validity

	public static boolean isValidLogin(String username) {
		String regex = "[a-zA-Z0-9.]+";

		Pattern p = Pattern.compile(regex);

		if (username == null) {
			return false;
		}
		Matcher m = p.matcher(username);
		return m.matches();
	}
	
	
	//Function to check password validity


	public static boolean isValidPsw(char[] psw) {
	

		if (psw.length < 2) {
			
			return false;

		}

		
		String regex="^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[@$!%*#?&])[A-Za-z0-9@$!%*#?&]{8,}$";// rajouter une règle s'il faut (caractères spciaux)

	    
		Pattern p = Pattern.compile(regex);
		
		Matcher m = p.matcher(String.valueOf(psw));
		
		return m.matches();

	}
	
	//Function to check password confirmation matching with the password
	
		public static boolean isValidConf(char[] psw, char[] confpsw) {
			
			return String.valueOf(psw).equals(String.valueOf(confpsw));
			
			
			
		}
		

	//Function to check first name and last name validity

	public static boolean isValidName(String lastname) {

		String regex = "[a-zA-Z- àéèêëâôîïö]+";

		Pattern p = Pattern.compile(regex);

		if (lastname==null) {
			
			return false;
		}
		
		Matcher m = p.matcher(lastname);
		return m.matches();
		

		
	}
	 public static boolean isValidString(String input) {
	        String regex = "[A-Za-z ]{3,50}$";
	        Pattern p = Pattern.compile(regex);
	        if (input==null) {
	            
	            return false;
	        }
	        
	        Matcher m = p.matcher(input);
	        return m.matches();
	    }
	 public static boolean isValidAddress(String input) {
	        String regex = "[A-Za-z0-9 ]{3,250}$";
	        Pattern p = Pattern.compile(regex);
	        if (input==null) {
	            
	            return false;
	        }
	        
	        Matcher m = p.matcher(input);
	        return m.matches();
	    }
	
	
	
	

	
	
}
