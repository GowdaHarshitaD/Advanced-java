package LAB3;

public class RemoveWhitespace {

	    public static String removeWhitespace(String str) {
	        return str.replaceAll("\\s+", "");
	    }

	    public static void main(String[] args) {
	        String str = "Java Programming Language";

	        System.out.println("Original: " + str);
	        System.out.println("Without Spaces: " + removeWhitespace(str));
	    }
	}

