package Test;

import java.io.FileInputStream;
import java.util.Scanner;

public class Prime {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		 Scanner scanner = new Scanner(System.in);
	        int t = scanner.nextInt(); // số lượng test cases

	        for (int i = 0; i < t; i++) {
	            int m = scanner.nextInt();
	            int n = scanner.nextInt();

	            generatePrimesInRange(m, n);

	            // In ra dòng trống giữa các test case
	            if (i < t - 1) {
	                System.out.println();
	            }
	        }
	    }

	    private static void generatePrimesInRange(int m, int n) {
	        for (int num = m; num <= n; num++) {
	            if (isPrime(num)) {
	                System.out.println(num);
	            }
	        }
	    }

	    private static boolean isPrime(int num) {
	        if (num < 2) {
	            return false;
	        }
	        for (int i = 2; i * i <= num; i++) {
	            if (num % i == 0) {
	                return false;
	            }
	        }
	        return true;
	}

}
