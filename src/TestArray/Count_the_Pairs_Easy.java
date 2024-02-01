package TestArray;

import java.io.FileInputStream;
import java.util.Scanner;

public class Count_the_Pairs_Easy {
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner = new Scanner(System.in);
		int TestCase, N, K;
		TestCase = scanner.nextInt();
		for (int test = 1; test <= TestCase; test++) {
			N = scanner.nextInt();
			K = scanner.nextInt();
			//System.out.println("K="+K);
			int[] array=new int[N];

			for (int i = 0; i < N; i++) {
				array[i] = scanner.nextInt();
			}
			// sắp xếp giảm dần
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if (array[i] < array[j]) {
						int tg = array[i];
						array[i] = array[j];
						array[j] = tg;
					}
				}
			}
			// xuất mảng
//			for (int i = 0; i < N; i++) {
//				System.out.print(array[i] + "   ");
//			}
//
//			System.out.println();
			// tính hiệu
			int count = TinhHieu(array, N, K);
			System.out.println(count);
		}
	}

	public static int TinhHieu(int[] array, int N, int K) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if(array[i]-array[j]==K) {count++;}
				
			}

		}
		return count;
	}
	

}
