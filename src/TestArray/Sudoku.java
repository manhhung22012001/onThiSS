package TestArray;

import java.io.FileInputStream;
import java.util.Scanner;

public class Sudoku {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner = new Scanner(System.in);

		int TestCase;
		TestCase = scanner.nextInt();
		scanner.nextLine();

		for (int testcase = 0; testcase < TestCase; testcase++) {
			int ans = -1;
			char[][] maxtrix = new char[9][9];
			for (int i = 0; i < 9; i++) {
				String row = scanner.nextLine();
				maxtrix[i] = row.toCharArray();
			}
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (maxtrix[i][j] != '.') {

						ans = Check(maxtrix, i, j);
						// System.out.println("ans= "+ans);
						if (ans == 0) {
							break;
						}
					}
				}
				if (ans == 0) {
					break;
				}
			}
			System.out.println("#" + (testcase + 1) + " " + ans);

		}

	}

	public static int Check(char[][] matrix, int row, int col) {
		// check hàng
		int count = 0;
		for (int j = 0; j < 9; j++) {
			if (matrix[row][col] == matrix[row][j] && col != j) {

				return 0;
			}
		}

		// check cột
		for (int i = 0; i < 9; i++) {
			if (matrix[row][col] == matrix[i][col] && row != i) {

				return 0;
			}
		}

		// check ma trận 3x3
		int kvRow = (row / 3) * 3;
		int kvCol = (col / 3) * 3;
		for (int i = kvRow; i < kvRow + 3; i++) {
			for (int j = kvCol; j < kvCol + 3; j++) {
				if (matrix[i][j] == matrix[row][col] && (i != row && j != col)) {

					return 0;
				}
			}
		}

		// Nếu không có trùng lặp, trả về 1 để cho biết là hợp lệ

		return 1;
	}

}
