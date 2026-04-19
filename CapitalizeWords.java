package LAB3;

public class CapitalizeWords {


	    public static String capitalizeWords(String str) {
	        String[] words = str.split(" ");
	        String result = "";

	        for (String word : words) {
	            if (word.length() > 0) {
	                result += Character.toUpperCase(word.charAt(0)) 
	                        + word.substring(1).toLowerCase() + " ";
	            }
	        }
	        return result.trim();
	    }

	    public static void main(String[] args) {
	        String str = "java programming language";

	        System.out.println("Original: " + str);
	        System.out.println("Capitalized: " + capitalizeWords(str));
	    }
	}

