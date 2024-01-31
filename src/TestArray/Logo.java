package TestArray;

import java.io.FileInputStream;
import java.util.Scanner;

public class Logo {
	// đối xứng qua đường chéo chính
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner = new Scanner(System.in);

		int Tc, N;
		Tc = scanner.nextInt();
		for (int testcase = 1; testcase <= Tc; testcase++) {
			N = scanner.nextInt();
			int[][] matrix = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = scanner.nextInt();
				}
			}
			// vị trí chính giữa ma trận. đây là ma trận vuông nên j=j
			int viTri = N / 2;// => điểm chính giữa là (viTri,viTri)
			boolean check = CheckMatrix(matrix, viTri, N);
			if(check) {System.out.println("#" + testcase + " YES");}else {System.out.println("#" + testcase + " NO");}
			
		}

	}

	public static boolean CheckMatrix(int[][] matrix, int viTri, int N) {
		boolean doiXung = false;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (N % 2 != 0) {// ma trận cạnh lẻ
					// trường hợp 1 là vị trí chính giữa. chính giữa bằng 1 hay 0 đều là true
					if (i == viTri && j == viTri) {
						doiXung = true;
					}

					// trường hợp 1 nằm trên trục dọc và không nằm trên trục ngang
					if (matrix[i][j] == 1 && j == viTri && i != viTri) {
						int temp = viTri - i;
						if ((viTri + temp) < N && matrix[i][j] == matrix[viTri + temp][j]) {
							doiXung = true;
//							System.out.println("Đối xứng trục dọc với i= " + i + " j= " + j + "với giá trị "
//									+ matrix[viTri + temp][j] + " tại vị trí mới i= " + (viTri + temp) + " j= " + j);
						} else {

							return false;
						}
					}

					// trường hợp nằm trên trục ngang và k nằm trên trục dọc
					if (matrix[i][j] == 1 && i == viTri && j != viTri) {
						int temp = viTri - j;
						if ((viTri + temp) < N && matrix[i][j] == matrix[i][viTri + temp]) {
							doiXung = true;
//							System.out.println("Đối xứng trục ngang với i= " + i + " j= " + j + "với giá trị "
//									+ matrix[i][viTri + temp] + " tại vị trí mới i= " + i + " j= " + (viTri + temp));
						} else {

							return false;
						}
					}

					// trường hợp nằm ở vị trí khác tâm và trục dọc ngang
					if (matrix[i][j] == 1 && i != viTri && j != viTri) {
						int tem1 = viTri - j;
						int tem2 = viTri - i;
						if ((viTri + tem1) < N && (viTri + tem2) < N && matrix[i][j] == matrix[i][tem1 + viTri]
								&& matrix[i][j] == matrix[tem2 + viTri][j]) {
							doiXung = true;
//							System.out.println("K Đối xứng với i= " + i + " j= " + j + "với giá trị qua trục ngang là  "
//									+ matrix[i][tem1 + viTri] + " tại vị trí mới i= " + i + " j= " + (tem1 + viTri)
//									+ "với giá trị qua trục dọc là  " + matrix[tem2 + viTri][j] + " tại vị trí mới i= "
//									+ (tem2 + viTri) + " j= " + j);
						} else {
							return false;
						}
					}
				} else {
					// là cạnh lẻ
					// check đối xứng qua chục tung
					if (matrix[i][j] == matrix[i][N - j - 1]) {
						doiXung = true;
					} else {
						return false;
					}

					// check đối xứng qua chục hoành
					if (matrix[i][j] == matrix[N - i - 1][j]) {
						doiXung = true;
					} else {
						return false;
					}
				}

			}

		}

		return doiXung;
	}

}
