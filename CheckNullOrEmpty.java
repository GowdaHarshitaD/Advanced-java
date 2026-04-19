package LAB3;

public class CheckNullOrEmpty {


	    public static boolean isNullOrEmpty(String str) {
	        return (str == null || str.trim().isEmpty());
	    }

	    public static void main(String[] args) {
	        String str = "   ";

	        if (isNullOrEmpty(str)) {
	            System.out.println("String is null or empty");
	        } else {
	            System.out.println("String is not empty");
	        }
	    }
	}

