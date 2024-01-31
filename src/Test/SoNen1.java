package Test;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class SoNen1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner = new Scanner(System.in);
		int TestCase, n;
		TestCase = scanner.nextInt();

		for (int test = 0; test < TestCase; test++) {
			n = scanner.nextInt();
			System.out.print("#" + (test + 1) + " ");
			while (n >= 10) {
				int sum = 0;
				while (n > 0) {
					sum += n % 10;
					n /= 10;
				}
				n = sum;
			}

			System.out.print(n + " ");
			System.out.println();
		}

	}

}
