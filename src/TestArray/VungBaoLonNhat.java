package TestArray;

import java.io.FileInputStream;
import java.util.Scanner;

public class VungBaoLonNhat {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner = new Scanner(System.in);
		int TestCase, H, W, M, N;
		TestCase = scanner.nextInt();
		for (int test = 0; test < TestCase; test++) {
			// nhập H,W,M,N
			H = scanner.nextInt();
			W = scanner.nextInt();
			M = scanner.nextInt();
			N = scanner.nextInt();
			int[][] matrix = new int[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = scanner.nextInt();
				}
			}

			int maxOfHW = finMax(matrix, H, W, M, N);
			System.out.println("#" + (test + 1) + " " + maxOfHW);
		}
	}

	public static int finMax(int[][] matrix, int H, int W, int M, int N) {
		int max = 0;
		// duyệt qua tất cả các ma trận HW
		for (int i = 0; i <= M - H; i++) {
			for (int j = 0; j <= N - W; j++) {
				int count = tinhTong(matrix, i, j, H, W);
				if (count > max) {
					max = count;
					// System.err.println(count);
				}
			}
		}

		return max;
	}

	public static int tinhTong(int[][] matrix, int startRow, int startColumn, int H, int W) {
		int sum = 0;
		
		//System.err.println("row: "+startRow+" col:"+startColumn);
		// cộng các cạnh nằm trên cạnh trên của HCN
		for (int j = startColumn; j < startColumn + W; j++) {
			if (matrix[startRow][j] % 2 == 0) {
				sum += matrix[startRow][j];
				//System.err.println("sum1: "+sum);
			}
		}
		// cộng các cạnh nằm trên cạnh dưới của HCN
		for (int j = startColumn; j < startColumn + W; j++) {
			if (matrix[startRow + H - 1][j] % 2 == 0) {
				sum += matrix[startRow + H - 1][j];
				//System.err.println("sum2: "+sum);
			}
		}
		// cộng các cạnh nằm bên trái của HCN
		for (int i = startRow+1; i < startRow + H-1; i++) {
			if (matrix[i][startColumn] % 2 == 0) {
				sum += matrix[i][startColumn];
				//System.err.println("sum3: "+sum+" với i= "+i+" với j= "+startColumn+ " giá trị là: "+matrix[i][startColumn]);
				
			}
		}
		
		// cộng các cạnh nằm bên phải của HCN
		for (int i = startRow+1; i < startRow + H-1; i++) {
		    if (matrix[i][startColumn + W - 1] % 2 == 0) {
		        sum += matrix[i][startColumn + W - 1];
		        //System.err.println("sum4: "+sum);
		    }
		}

		//System.err.println("sum5: "+sum);
		return sum;
	}

}
