package TestArray;

import java.io.FileInputStream;
import java.util.Scanner;

public class FirstDuplicate {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner = new Scanner(System.in);
		
		int TestCase, N;
		TestCase = scanner.nextInt();
		//boolean[] check = new boolean[N];

		for (int test = 0; test < TestCase; test++) {
			N = scanner.nextInt();
			boolean[] check = new boolean[N+1];
			for (int i = 0; i < check.length; i++)
				check[i] = false;
			int ans = -1, a;
			for (int i = 0; i < N; i++) {
				a = scanner.nextInt();
				// System.out.println("a= "+a);
				if (check[a] && ans == -1) {
					ans = a;
					// System.out.println(check[a]);
				} else {
					check[a] = true;
				}
			}

			System.out.println("#" + (test + 1) + " " + ans);
		}
	}
}
