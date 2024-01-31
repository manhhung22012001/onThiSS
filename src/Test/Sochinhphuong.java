package Test;

import java.util.Scanner;
import java.io.FileInputStream;

public class Sochinhphuong {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner = new Scanner(System.in);
		int T, a, b;
		T = scanner.nextInt(); // Số lượng test case
		for (int i = 0; i < T; i++) {
			a = scanner.nextInt();
			b = scanner.nextInt();
			System.out.print("#" + (i + 1) + " ");
			duyetSo(a, b);
			System.out.println();
//            boolean foundPerfectSquare = false;
//			for(int j=a;j<=b;j++) {
//				int sqrt = (int) Math.sqrt(j);
//				if(sqrt*sqrt == j) {
//					
//					System.out.print(j + " ");
//					foundPerfectSquare = true;
//				}
//				
//			}
//			if(!foundPerfectSquare) {
//				System.out.print("NO NUMBER");
//			}

		}

	}

	public static void duyetSo(int a, int b) {
		boolean flag = false;
		for (int i = a; i <= b; i++) {
			if (checkSo(i)) {
				System.out.print(i + " ");
				flag = true;
			}

		}
		if (!flag) {
			System.out.print("NO NUMBER");
		}
	}

	public static boolean checkSo(int c) {
		int sqrt = (int) Math.sqrt(c);
		return sqrt * sqrt == c;
	}

}
