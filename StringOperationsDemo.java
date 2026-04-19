package LAB2;

import java.util.*;

public class StringOperationsDemo {



	    public static void main(String[] args) {
	        
	        // 1. String Creation and Basic Operations
	        String str1 = "Hello";
	        String str2 = new String("World");
	        System.out.println("String 1: " + str1);
	        System.out.println("String 2: " + str2);
	        
	        // 2. Length and Character Access
	        System.out.println("\nLength of str1: " + str1.length());
	        System.out.println("Character at index 1: " + str1.charAt(1));
	        
	        // 3. String Comparison
	        String str3 = "hello";
	        System.out.println("\nEquals: " + str1.equals(str3));
	        System.out.println("Equals Ignore Case: " + str1.equalsIgnoreCase(str3));
	        System.out.println("CompareTo: " + str1.compareTo(str2));
	        
	        // 4. String Searching
	        String text = "Java Programming Language";
	        System.out.println("\nIndex of 'Program': " + text.indexOf("Program"));
	        System.out.println("Last index of 'a': " + text.lastIndexOf('a'));
	        System.out.println("Contains 'Java'? " + text.contains("Java"));
	        
	        // 5. Substring Operations
	        System.out.println("\nSubstring (0-4): " + text.substring(0, 4));
	        System.out.println("Substring from index 5: " + text.substring(5));
	        
	        // 6. String Modification
	        String modified = text.replace("Java", "Advanced Java");
	        System.out.println("\nAfter Replace: " + modified);
	        System.out.println("To Upper Case: " + text.toUpperCase());
	        System.out.println("To Lower Case: " + text.toLowerCase());
	        
	        // 7. Whitespace Handling
	        String spaceStr = "   Hello Java   ";
	        System.out.println("\nBefore Trim: '" + spaceStr + "'");
	        System.out.println("After Trim: '" + spaceStr.trim() + "'");
	        
	        // 8. String Concatenation
	        String concat = str1 + " " + str2;
	        System.out.println("\nConcatenated String: " + concat);
	        System.out.println("Using concat(): " + str1.concat(" ").concat(str2));
	        
	        // 9. String Splitting
	        String sentence = "Java,Python,C++,JavaScript";
	        String[] languages = sentence.split(",");
	        System.out.println("\nSplit Strings:");
	        for (String lang : languages) {
	            System.out.println(lang);
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
	        
	        // 12. Email Validation using contains(), startsWith(), endsWith()
	        String email = "example@gmail.com";
	        
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
