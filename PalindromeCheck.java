package LAB3;

public class PalindromeCheck {


	    public static boolean isPalindrome(String str) {
	        // Remove non-alphanumeric characters
	        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

	        int left = 0;
	        int right = str.length() - 1;

	        while (left < right) {
	            if (str.charAt(left) != str.charAt(right)) {
	                return false;
	            }
	            left++;
	            right--;
	        }
	        return true;
	    }

	    public static void main(String[] args) {
	        String str = "A man, a plan, a canal: Panama";

	        if (isPalindrome(str)) {
	            System.out.println("Palindrome");
	        } else {
	            System.out.println("Not Palindrome");
	        }
	    }
	
}
