package Test;

import java.io.FileInputStream;
import java.util.Scanner;

public class TinhLuyThua {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner = new Scanner(System.in);
		int TestCase, a,b;
		TestCase = scanner.nextInt();
		for (int test = 0; test < TestCase; test++) {
			a=scanner.nextInt();
			b=scanner.nextInt();
			int luythua=1;
			System.out.print("#" + (test + 1) + " ");
			for(int i=0;i<b;i++) {
				luythua*=a;
			}
			System.out.print(luythua + " ");
			System.out.println();
		}
	}

}
