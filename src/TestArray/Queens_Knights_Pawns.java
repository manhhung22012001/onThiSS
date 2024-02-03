package TestArray;

import java.io.FileInputStream;
import java.util.Scanner;

public class Queens_Knights_Pawns {
	public static final int[] knightMoveX = { +2, +1, -1, -2, -2, -1, +1, +2 };// mã đi 8 hướng chiều X
	public static final int[] knightMoveY = { +1, +2, +2, +1, -1, -2, -2, -1 };// mã đi 8 hướng chiều Y
	public static final int[] qCrossMoveX = { +1, +1, -1, -1 };// hậu đi chéo
	public static final int[] qCrossMoveY = { +1, -1, +1, -1 };// hậu đi chéo
	public static final int[] qStraightMove = { +1, -1 };// hậu đi tiến lùi sang bên
	public static int[][] array = new int[1005][1005];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner = new Scanner(System.in);

		int TC = 1;

		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();

			if (m == 0 && n == 0) {
				break;
			}

			array = new int[n][m];
			int giatri = 2;
//			for (int dong = 0; dong < 3; dong++) {
//				int viTri = 0;
//				viTri = scanner.nextInt();
//				if (viTri == 0) {
//					break;
//				}
//				for (int i = 0; i < viTri; i++) {
//					int row = scanner.nextInt() - 1;
//					int col = scanner.nextInt() - 1;
//					array[row][col] = giatri;
//				}
//				giatri++;
//			}
			int numQueens = scanner.nextInt();
			int[][] queens = new int[numQueens][2];
			for (int i = 0; i < numQueens; i++) {
				int row = scanner.nextInt() - 1;
				int col = scanner.nextInt() - 1;
				array[row][col] = giatri;
			}
			giatri++;
			int numKnights = scanner.nextInt();
			int[][] knights = new int[numKnights][2];
			for (int i = 0; i < numKnights; i++) {
				int row = scanner.nextInt() - 1;
				int col = scanner.nextInt() - 1;
				array[row][col] = giatri;
			}
			giatri++;

			int numPawns = scanner.nextInt();
			int[][] pawns = new int[numPawns][2];
			for (int i = 0; i < numPawns; i++) {
				int row = scanner.nextInt() - 1;
				int col = scanner.nextInt() - 1;
				array[row][col] = giatri;
			}
			giatri++;
			// duyệt mảng
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (array[i][j] == 2) {
						array = CheckSafeQ(array, i, j, n, m);
					} else if (array[i][j] == 3) {
						array = CheckSafeK(array, i, j, n, m);
					}
				}
			}
			int countSafe = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (array[i][j] == 0) {
						countSafe++;
					}
				}
			}
			System.out.println("Board " + TC + " has " + countSafe + " safe squares.");
			TC++;
		}

	}

	public static int[][] CheckSafeQ(int[][] array, int viTriHang, int viTriCot, int n, int m) {

		// hậu đây
		// xử lý hậu đi tiến lùi thì +2

		boolean flag = true;
		for (int i = 0; i < 2; i++) {// hậu có thể đi 1 bước ngang or chéo xong ++ lên,+2 là do hậu có thể đi chép
										// thì i và j + hoặc - 1 đơn vị.
			int newRow = viTriHang + qStraightMove[i];
			int newCol = viTriCot + qStraightMove[i];
			while (true) {// tiến lùi

				if (newRow >= 0 && newRow < n && array[newRow][viTriCot] != 2 && array[newRow][viTriCot] != 3
						&& array[newRow][viTriCot] != 4) {
					array[newRow][viTriCot] = 1;
					newRow += qStraightMove[i];
				} else {
					break;
				}
			}
			while (true) {// ngang 2 bên
				if (newCol >= 0 && newCol < m && array[viTriHang][newCol] != 2 && array[viTriHang][newCol] != 3
						&& array[viTriHang][newCol] != 4) {
					array[viTriHang][newCol] = 1;
					newCol += qStraightMove[i];
				} else {
					break;
				}
			}

		}
		// xử lý hậu đi chéo
		for (int i = 0; i < 4; i++) {
			// System.out.println("vị trí ban đầu i= "+viTriHang+" j "+viTriCot);
			int newRow = viTriHang + qCrossMoveX[i];
			int newCol = viTriCot + qCrossMoveY[i];

			while (true) {

				if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && array[newRow][newCol] != 2
						&& array[newRow][newCol] != 4 && array[newRow][newCol] != 3) {

					array[newRow][newCol] = 1;
					newRow += qCrossMoveX[i];
					newCol += qCrossMoveY[i];

				} else {
					break;
				}

			}
		}

		return array;
	}

	public static int[][] CheckSafeK(int[][] array, int viTriHang, int viTriCot, int n, int m) {

		// mã có thể di chuyển hình chữ L trong 8 hướng. xem ở dòng 19,20
		for (int i = 0; i < 8; i++) {
			int newRow = viTriHang + knightMoveX[i];
			int newCol = viTriCot + knightMoveY[i];

			if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && array[newRow][newCol] != 2
					&& array[newRow][newCol] != 3 && array[newRow][newCol] != 4) {
				array[newRow][newCol] = 1;// nếu di chuyển được thì bằng 1

			}
		}

		return array;
	}
}
