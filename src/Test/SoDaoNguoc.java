package Test;

import java.io.FileInputStream;
import java.util.Scanner;

public class SoDaoNguoc {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner = new Scanner(System.in);
		int TestCase, a,b;
		TestCase = scanner.nextInt();
		for (int test = 0; test < TestCase; test++) {
			a = scanner.nextInt();
			b = scanner.nextInt();
			int sum=daonguoc(a)+ daonguoc(b);
			System.out.println(daonguoc(sum) + " ");
		}
	}
	public static int daonguoc(int c) {
		int result=0;
		while(c>0) {
			int tg=c%10;
			c/=10;
			result=result*10+tg;
		}
		return result;
	}

}
