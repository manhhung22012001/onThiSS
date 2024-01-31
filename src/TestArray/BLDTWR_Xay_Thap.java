package TestArray;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Arrays;

public class BLDTWR_Xay_Thap {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner = new Scanner(System.in);
		int TestCase, N, M1, M2;
		TestCase = scanner.nextInt();
		for (int test = 1; test <= TestCase; test++) {
			N = scanner.nextInt();
			M1 = scanner.nextInt();
			M2 = scanner.nextInt();

			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = scanner.nextInt();

			}
			int[] sapXep = swap(arr, N);
			int result = TinhTong(sapXep, N, M1, M2);
			System.out.println("#" + test + " " + result);
		}
	}

	public static int[] swap(int[] arr, int N) {
		// sắp xếp bằng tay
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (arr[j] > arr[i]) {
					int tg = 0;
					tg = arr[i];
					arr[i] = arr[j];
					arr[j] = tg;
				}
			}

		}
		// sx theo cách khác
		// Arrays.sort(arr); // Sắp xếp mảng theo mảng giảm dần để lấy phần tử đầu tiên
		// to nhất nhân với tầng thấp nhất thì chi phí sẽ thấp nhất
		return arr;
	}

	public static int TinhTong(int[] sapXep, int N, int M1, int M2) {
		int result1 = 0;
		int currIdx = 0;
		int minM = (M1 < M2) ? M1 : M2;
		int mAxM = (M1 > M2) ? M1 : M2;
		for (int i = 0; i < N; i++) {
			System.out.print(sapXep[i]);
		}
		for (int i = 1; i <= minM; i++) {
			result1 += (sapXep[currIdx] + sapXep[currIdx + 1]) * i;
			currIdx += 2;
			System.out.println("result1= " + result1);
		}

		for (int i = minM + 1; i <= mAxM; i++) {
			result1 += sapXep[currIdx] * i;
			currIdx += 1;
			System.out.println("result12= " + result1);
		}

		return result1;
	}

}
