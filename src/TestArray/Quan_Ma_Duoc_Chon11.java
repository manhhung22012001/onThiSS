package TestArray;

import java.io.FileInputStream;
import java.util.Scanner;

public class Quan_Ma_Duoc_Chon11 {
	public static final int[] KMoveX = { +2, +1, -1, -2, -2, -1, +1, +2 };
	public static final int[] KMoveY = { +1, +2, +2, +1, -1, -2, -2, -1 };
	public static int[] viTriKX, viTriKY;
	//public static int maxCount;
	public static int N;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
        Scanner scanner = new Scanner(System.in);
        
        int TestCase, K, M, D;
        TestCase = scanner.nextInt();
        for (int test = 1; test <= TestCase; test++) {
            N = scanner.nextInt();
            K = scanner.nextInt();
            M = scanner.nextInt();
            D = scanner.nextInt();

            int[][] banCo1 = new int[N][N];
            viTriKX = new int[K];
            viTriKY = new int[K];
            int maxCount = 0;

            // Nhập vị trí mã là quân K (số 3)
            for (int i = 0; i < K; i++) {
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                banCo1[row][col] = 3;
                viTriKX[i] = row;
                viTriKY[i] = col;
            }

            // Nhập vị trí tốt là quân M (số 6)
            for (int i = 0; i < M; i++) {
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                banCo1[row][col] = 6;
            }

            // Nhập vị trí quân k ăn được D (số 9)
            for (int i = 0; i < D; i++) {
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                banCo1[row][col] = 9;
            }

            int[] max = new int[K];
            int vitri = -1;

            for (int i = 0; i < K; i++) {
                max[i] = Check(banCo1, N, viTriKX[i], viTriKY[i]);
                if (max[i] > maxCount) {
                    maxCount = max[i];
                    vitri = i;
                }
            }

            // Xuất kết quả
            System.out.println("#" + test + " " + viTriKX[vitri] + " " + viTriKY[vitri] + " " + maxCount);
        }
       
    }

	 public static int Check(int[][] banCo1, int N, int row, int col) {
	        int count = 0;
	        int[][] tg = new int[N][N];

	        // Sao chép mảng banCo1 vào mảng tg
	        for (int i = 0; i < N; i++) {
	            System.arraycopy(banCo1[i], 0, tg[i], 0, N);
	        }

	        for (int i = 0; i < 8; i++) {
	            int newRow = row + KMoveX[i];
	            int newCol = col + KMoveY[i];

	            if (newRow >= 0 && newCol >= 0 && newRow < N && newCol < N && tg[newRow][newCol] == 6) {
	                count++;
	                tg[newRow][newCol] = 3;
	            }
	        }

	        return count;
	    }

	}
