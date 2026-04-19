package LAB2;

public class StringPerformanceTest {



	    public static void main(String[] args) {

	        int iterations = 10000;

	        // 1. StringBuffer Performance Test
	        StringBuffer sbf = new StringBuffer();
	        long startTimeBuffer = System.currentTimeMillis();

	        for (int i = 0; i < iterations; i++) {
	            sbf.append("AIET");
	        }

	        long endTimeBuffer = System.currentTimeMillis();
	        System.out.println("StringBuffer Time: " + (endTimeBuffer - startTimeBuffer) + " ms");

	        // 2. StringBuilder Performance Test
	        StringBuilder sbd = new StringBuilder();
	        long startTimeBuilder = System.currentTimeMillis();

	        for (int i = 0; i < iterations; i++) {
	            sbd.append("AIET");
	        }

	        long endTimeBuilder = System.currentTimeMillis();
	        System.out.println("StringBuilder Time: " + (endTimeBuilder - startTimeBuilder) + " ms");
	    }
	}

