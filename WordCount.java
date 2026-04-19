package LAB3;

public class WordCount {

	    public static int countWords(String str) {
	        if (str == null || str.trim().isEmpty()) {
	            return 0;
	        }
	        String[] words = str.trim().split("\\s+");
	        return words.length;
	    }

	    public static void main(String[] args) {
	        String str = "Java is a powerful programming language";

	        System.out.println("Word Count: " + countWords(str));
	    }
	
}
