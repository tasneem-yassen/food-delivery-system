//this is a helper class that has methods to validate user input 
public class InputValidation {
	//this method checks if string is only digits and return true if it is and false otherwise 
	public static boolean isOnlyDigits(String string) {
			string = string.trim();
			for (int i = 0; i < string.length(); i++) {
				if(!Character.isDigit(string.charAt(i))) {
					return false;
				}
			} 
			return true;
	}
	//this method checks if string is empty and returns true if it isnt and false otherwise 
	public static boolean isNotEmpty(String string) {
		if(string != null && !string.trim().isEmpty()) {
			return true;
		}
		return false; 
	}
	//this method checks if string has only letters and return true if it is anf false otherwise 
	public static boolean isOnlyLetters(String string) {
		string = string.trim();
		for (int i = 0; i < string.length(); i++) {
			if(!Character.isLetter(string.charAt(i))) {
				return false;
			}
		}
		return true; 
	}
	//this method checks if the email is valid : contains only one "@" and its not at the start, a "." after it,
	public static boolean isValidEmail(String mail) {
		if(!isNotEmpty(mail)) {
				return false;
		}
		mail = mail.trim();
		int atIndex = mail.indexOf("@");
		int lastIndex = mail.lastIndexOf("@");
		if(atIndex != lastIndex) { //more than one @
			return false;
		}
		if(atIndex <= 0 || atIndex == mail.length()-1) { // @ is first or last 
			return false;
		}
		int dotAfterAt = mail.indexOf(".",atIndex); // no dot after @ or dot immediately after @
		if(dotAfterAt == -1 || dotAfterAt == atIndex +1) {
			return false;
		}
		if(dotAfterAt == mail.length()-1) { // dot at end 
			return false;
		}
		return true; 
	}
	//this method checks if the id is valid 
	public static boolean isValidId(String id) {
		if(!isNotEmpty(id)) {
			return false;
		}
		if(!isOnlyDigits(id)) {
			return false;
		}
		id = id.trim();
		if(id.length() != 9) {
			return false;
		}
		return true; 
	}
	//this method checks if the zipCode is valid 
	public static boolean isValidZipCode(String zip) {
		if(!isNotEmpty(zip)) {
			return false;
		}
		if(!isOnlyDigits(zip)) {
			return false;
		}
		zip = zip.trim();
		if(zip.length() < 5 || zip.length() > 7 ) {
			return false;
		}
		return true;
	}
	//this method checks if string only has letters and spaces 
	public static boolean isOnlyLettersAndSpaces(String s) {
		if(!isNotEmpty(s)) {
			return false;
		}
		for(int i = 0 ; i<s.length();i++) {
			char current = s.charAt(i);
			if(!Character.isLetter(current) && current != ' ') {
				return false;
			}
		}
		return true; 
	}
}
