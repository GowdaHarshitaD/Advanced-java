package LAB3;

public class TruncateString {

	    public static String truncate(String str, int length) {
	        if (str.length() <= length) {
	            return str;
	        }
	        return str.substring(0, length) + "...";
	    }

	    public static void main(String[] args) {
	        String str = "Java Programming Language";

	        System.out.println("Truncated: " + truncate(str, 10));
	    }
	
}
