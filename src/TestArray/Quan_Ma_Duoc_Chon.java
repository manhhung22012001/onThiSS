package TestArray;

import java.io.FileInputStream;
import java.util.Scanner;

public class Quan_Ma_Duoc_Chon {
	public static final int[] KMoveX = { +2, +1, -1, -2, -2, -1, +1, +2 };
	public static final int[] KMoveY = { +1, +2, +2, +1, -1, -2, -2, -1 };
	public static int[] viTriKX, viTriKY;
	public static int maxCount;
	public static int[][] banCo;
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
			// khai báo bàn cờ
			int[][] banCo1 = new int[N][N];
			viTriKX = new int[K];
			viTriKY = new int[K];
			maxCount = 0;
			// nhập vị trí mã là quân K, gọi mà là số 3
			for (int i = 0; i < K; i++) {
				int row = scanner.nextInt();
				int col = scanner.nextInt();
				banCo1[row][col] = 3;
				viTriKX[i] = row;
				viTriKY[i] = col;

			}

			// nhập vị trí tốt là quân M, gọi là 6.
			for (int i = 0; i < M; i++) {
				int row = scanner.nextInt();
				int col = scanner.nextInt();
				banCo1[row][col] = 6;

			}
			// nhập vị trí quân k ăn được D, gọi là 9
			for (int i = 0; i < D; i++) {
				int row = scanner.nextInt();
				int col = scanner.nextInt();
				banCo1[row][col] = 9;

			}

			// duyệt quân mã
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (banCo1[i][j] == 3) {
						DemK(i, j, banCo1);
					}
				}

			}

			// nhìn bàn cờ
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(banCo1[i][j] + "   ");
				}
				System.out.println();
			}
			// Xuất kết quả
			// System.out.println("#" + test + " " + viTriKX[0] + " " + viTriKY[0] + " " +
			// maxCount);

		}
	}

	public static void DemK(int row, int col, int[][] banCo1) {
		int count = 0;
		int newRow = 0;
		int newCol = 0;
		int vitrithoamanX = row;
		int vitrithoamanY = col;
		//System.out.println("ma ở vi tri row= " + row + " col=" + col);
		for (int i = 0; i < 8; i++) {
			newRow = vitrithoamanX + KMoveX[i];
			newCol = vitrithoamanY + KMoveY[i];
			//System.out.println("ma moi ngoai while vi tri row= " + newRow + " col=" + newCol + " i= " + i);
			while (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N) {
				if (banCo1[newRow][newCol] != 9 && banCo1[newRow][newCol] != 3 && banCo1[newRow][newCol] == 6) {
//					System.out.println("ma TMMM o vi tri row= " + newRow + " col=" + newCol + " with KMoveX[i]="
//							+ KMoveX[i] + " with KMoveY[i]" + KMoveY[i] + " i=" + i);
					count++;
					banCo1[newRow][newCol] = 3; // Chuyển ô đó thành 3
					//System.out.println("Truoc khi cong: newRow=" + newRow + " newCol=" + newCol);
					vitrithoamanX=newRow;
					vitrithoamanY=newCol;
					newRow += KMoveX[i]; // Thêm bước di chuyển của mã
					newCol += KMoveY[i];
					//System.out
						//	.println("ma moi sau khi cong while vi tri row= " + newRow + " col=" + newCol + " i= " + i);
				} else if (banCo1[newRow][newCol] != 9 && banCo1[newRow][newCol] != 3 && banCo1[newRow][newCol] == 0) {
					banCo1[newRow][newCol] = 3; // Chuyển ô đó thành 3
					newRow += KMoveX[i]; // Thêm bước di chuyển của mã
					newCol += KMoveY[i];
					//System.out.println(
//							"ma moi trong while nhung =0 vi tri row= " + newRow + " col=" + newCol + " i= " + i);

				} else {
					break;
				}
			}
			if (count > maxCount) {
				maxCount = count;
			}
		}
		System.out.println("maxcount= " + maxCount);
	}

}
