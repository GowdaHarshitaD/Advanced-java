package LAB3;

public class CheckNumeric {


	    public static boolean isNumeric(String str) {
	        if (str == null || str.isEmpty()) return false;

	        for (char ch : str.toCharArray()) {
	            if (!Character.isDigit(ch)) {
	                return false;
	            }
	        }
	        return true;
	    }

	    public static void main(String[] args) {
	        String str = "12345";

	        if (isNumeric(str)) {
	            System.out.println("String is numeric");
	        } else {
	            System.out.println("String is not numeric");
	        }
	    }
	}

