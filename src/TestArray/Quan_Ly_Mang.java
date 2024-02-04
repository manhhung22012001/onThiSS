package TestArray;

import java.io.FileInputStream;
import java.util.Scanner;

public class Quan_Ly_Mang {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner = new Scanner(System.in);

		int TestCase, N;
		TestCase = scanner.nextInt();
		// boolean[] check = new boolean[N];

		for (int test = 0; test < TestCase; test++) {
			N = scanner.nextInt();
			int[] A = new int[N];

			for (int i = 0; i < N; i++) {
				A[i] = scanner.nextInt();
			}
//			// nhìn mảng
//			for (int i = 0; i < N; i++) {
//				System.out.print(A[i] + " ");
//			}
			int M = scanner.nextInt();// số lượng thao tác
			for (int i = 0; i < M; i++) {
				String tenLenh = scanner.next();
				//System.out.print("Ten Lenh ");
				if (tenLenh.equals("insert")) {
					int index = scanner.nextInt();
					int value = scanner.nextInt();
					// gọi hàm thêm phần tử
					A = insert(A, index, value, N);
				} else if (tenLenh.equals("update")) {
					int index = scanner.nextInt();
					int value = scanner.nextInt();
					// gọi hàm sửa phần tử
					A = update(A, index, value, N);
				} else if (tenLenh.equals("delete")) {
					int index = scanner.nextInt();
					A=delete(A, index, N);
				}

			}
			 // In kết quả
            System.out.print("#" + test + " ");
            for (int num : A) {
                System.out.print(num + " ");
            }
            System.out.println();
		}
	}

	public static int[] insert(int[] A, int index, int value, int N) {
		int[] newA = new int[A.length + 1];
		for (int i = 0; i < index; i++) {
			newA[i] = A[i];
		}
		newA[index] = value;
		for (int i = index + 1; i < newA.length; i++) {
			newA[i] = A[i - 1];
		}
		return newA;
	}

	public static int[] update(int[] A, int index, int value, int N) {

		A[index]=value;

		return A;
	}

	public static int[] delete(int[] A, int index, int N) {

		int[] newA = new int[A.length -1];
		for (int i = 0; i < index; i++) {
			newA[i] = A[i];
		}
		
		for (int i = index; i < newA.length; i++) {
			newA[i] = A[i + 1];
		}
		return newA;

		
	}
}
