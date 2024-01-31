package TestArray;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Arrays;

public class BLDTWR {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner = new Scanner(System.in);
		int TestCase, N, M1, M2;
		TestCase = scanner.nextInt();
		for (int test = 0; test < TestCase; test++) {
			N = scanner.nextInt();
			M1 = scanner.nextInt();
			M2 = scanner.nextInt();

			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = scanner.nextInt();

			}
			int[]  sapXep = toaM1(arr, N, M1, M2);
			int result= TinhTong(sapXep, N, M1, M2);
			//System.out.print(result + " ");
		}
	}

	public static int[] toaM1(int[] arr, int N, int M1, int M2) {
		int sumM1 = 0;
		int sumM2 = 0;
		int sum=0;
		// sắp xếp bằng tay
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (arr[j] < arr[i]) {
					int tg = 0;
					tg = arr[i];
					arr[i] = arr[j];
					arr[j] = tg;
				}
			}

		}
		// sx theo cách khác
		// Arrays.sort(arr); // Sắp xếp mảng theo tăng dần
		for (int i=0; i <N; i++) {
			System.out.print(arr[i] + " ");
			
		}
		return arr;
	}
	public static int TinhTong(int[] sapXep,int N, int M1, int M2 ) {
		int result1=0;
		int sum1=0;
		int sum2=0;
		int m1=M1, m2=M2;
		int i=0;
		//System.out.print(M2 + " ");
		 while (i < N && (m1 > 0 || m2 > 0)) {
		        if (i % 2 == 0) {
		            if (M1 > 0) {
		                sum1 += sapXep[i] * M1;
		                i++;
		                M1--;
		                System.out.println( "sum1 = "+sum1 );
		            }
		        } else {
		            if (M2 > 0) {
		                sum2 += sapXep[i] * M2;
		                i++;
		                M2--;
		                System.out.println( "sum2 = "+sum2 );
		            }
		        }
		    }
		System.out.print(sum1 + " ");
		System.out.print(sum2 + " ");
        return sum1+sum2;
    }
}
