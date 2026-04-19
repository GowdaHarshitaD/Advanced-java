package LAB3;
import java.util.*;
public class StringOperations {

	    public static void main(String[] args) {

	        // 1. String Creation and Basic Operations
	        String s1 = "Hello";
	        String s2 = new String("World");
	        System.out.println("String 1: " + s1);
	        System.out.println("String 2: " + s2);

	        // 2. Length and Character Access
	        System.out.println("\nLength of s1: " + s1.length());
	        System.out.println("Character at index 2: " + s1.charAt(2));

	        // 3. String Comparison
	        String s3 = "hello";
	        System.out.println("\nEquals: " + s1.equals(s3));
	        System.out.println("Equals Ignore Case: " + s1.equalsIgnoreCase(s3));
	        System.out.println("CompareTo: " + s1.compareTo(s2));

	        // 4. String Searching
	        String text = "Java Programming";
	        System.out.println("\nIndex of 'Pro': " + text.indexOf("Pro"));
	        System.out.println("Last index of 'a': " + text.lastIndexOf('a'));
	        System.out.println("Contains 'Java'? " + text.contains("Java"));

	        // 5. Substring Operations
	        System.out.println("\nSubstring (0-4): " + text.substring(0, 4));
	        System.out.println("Substring from index 5: " + text.substring(5));

	        // 6. String Modification
	        System.out.println("\nReplace: " + text.replace("Java", "Advanced Java"));
	        System.out.println("Upper Case: " + text.toUpperCase());
	        System.out.println("Lower Case: " + text.toLowerCase());

	        // 7. Whitespace Handling
	        String space = "   Hello Java   ";
	        System.out.println("\nBefore trim: '" + space + "'");
	        System.out.println("After trim: '" + space.trim() + "'");

	        // 8. String Concatenation
	        String concat = s1 + " " + s2;
	        System.out.println("\nConcatenation using +: " + concat);
	        System.out.println("Using concat(): " + s1.concat(" ").concat(s2));

	        // 9. String Splitting
	        String str = "Java,Python,C++,JavaScript";
	        String[] arr = str.split(",");
	        System.out.println("\nSplit Result:");
	        for (String val : arr) {
	            System.out.println(val);
	        }

	        // 10. StringBuilder Demo
	        StringBuilder sb = new StringBuilder("Java");
	        sb.append(" Programming");
	        sb.insert(4, " Language");
	        sb.replace(0, 4, "Advanced");
	        sb.delete(8, 16);
	        System.out.println("\nStringBuilder Result: " + sb);

	        // 11. String Formatting
	        String name = "Harshita";
	        int age = 20;
	        String formatted = String.format("Name: %s, Age: %d", name, age);
	        System.out.println("\nFormatted String: " + formatted);

	        // 12. Email Validation
	        String email = "student@gmail.com";

	        boolean isValid = email.contains("@") &&
	                          email.contains(".") &&
	                          (email.endsWith(".com") || email.endsWith(".in")) &&
	                          !email.startsWith("@");

	        System.out.println("\nEmail: " + email);
	        if (isValid) {
	            System.out.println("Valid Email");
	        } else {
	            System.out.println("Invalid Email");
	        }
	    }
	
}
