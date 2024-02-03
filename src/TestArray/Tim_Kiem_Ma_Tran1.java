package TestArray;

import java.io.FileInputStream;
import java.util.Scanner;

public class Tim_Kiem_Ma_Tran1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Số lượng test case

        for (int tc = 1; tc <= T; tc++) {
            int N = scanner.nextInt(); // Kích thước ma trận vuông
            int M = scanner.nextInt(); // Kích thước ma trận con
            int K = scanner.nextInt(); // Giá trị K

            int[][] A = new int[N][N];

            // Nhập dữ liệu cho ma trận A
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    A[i][j] = scanner.nextInt();
                }
            }

            int minDiff = Integer.MAX_VALUE;
            int resultRow = 0, resultCol = 0;

            // Duyệt qua từng vị trí có thể bắt đầu ma trận con
            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int sum = 0;

                    // Tính tổng ma trận con
                    for (int x = i; x < i + M; x++) {
                        for (int y = j; y < j + M; y++) {
                            sum += A[x][y];
                        }
                    }

                    // Tính chênh lệch giữa sum và K
                    int diff = Math.abs(sum - K);

                    // Nếu chênh lệch nhỏ hơn hoặc bằng minDiff, cập nhật kết quả
                    if (diff < minDiff || (diff == minDiff && (i < resultRow || (i == resultRow && j < resultCol)))) {
                        minDiff = diff;
                        resultRow = i;
                        resultCol = j;
                    }
                }
            }

            // In kết quả
            System.out.println("#" + tc + " " + (resultRow ) + " " + (resultCol ));
        }

       
	}

}
