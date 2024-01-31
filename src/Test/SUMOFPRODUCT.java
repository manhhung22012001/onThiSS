package Test;

import java.io.FileInputStream;
import java.util.Scanner;

public class SUMOFPRODUCT {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		  Scanner scanner = new Scanner(System.in);
	        int T = scanner.nextInt(); // Number of test cases

	        for (int i = 0; i < T; i++) {
	            int N = scanner.nextInt();

	            // Calculate the sum of products
	            long result = calculateSumOfProducts(N);

	            // Output the result modulo 1000007
	            System.out.println(result % 1000007);
	        }
	    }

	    private static long calculateSumOfProducts(int N) {
	        long sum = 0;

	        for (int x = 1; x <= N; x++) {
	            int y = N / x;
	            sum = (sum + (long) x * y) % 1000007;
	        }

	        return sum;
	    }

}
