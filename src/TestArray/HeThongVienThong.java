package TestArray;

import java.io.FileInputStream;
import java.security.PublicKey;
import java.util.Iterator;
import java.util.Scanner;

public class HeThongVienThong {
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

//    dx[0] = 0, dy[0] = -1: Di chuyển sang trái.
//    dx[1] = -1, dy[1] = 0: Di chuyển lên trên.
//    dx[2] = 0, dy[2] = 1: Di chuyển sang phải.
//    dx[3] = 1, dy[3] = 0: Di chuyển xuống dưới.
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner = new Scanner(System.in);
		int TestCase, A, B, C, M, N;
		int numberHome = 0;
		TestCase = scanner.nextInt();
		for (int test = 0; test < TestCase; test++) {
			// nhập H,W,M,N
			M = scanner.nextInt();
			N = scanner.nextInt();
			
			
			// tạo bản đồ
			char[][] map = new char[M][N];
			// đọc vào bản đồ
			for (int i = 0; i < M; i++) {
				String row = scanner.next();
				map[i] = row.toCharArray();

			}
			numberHome = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'H') {
						numberHome++;
					}
				}
			}
			//System.out.println(numberHome);
			int numberHomeisTrue = 0;
			// kiểm tra các điểm phủ sóng
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'A') {
						numberHomeisTrue += checkPhuSong(map, i, j, 1,M,N);
					} else if (map[i][j] == 'B') {
						numberHomeisTrue += checkPhuSong(map, i, j, 2,M,N);
					} else if (map[i][j] == 'C') {
						numberHomeisTrue += checkPhuSong(map, i, j, 3,M,N);
					}
				}
			}
			 System.out.println("#" + (test+1) + " " + (numberHome - numberHomeisTrue));

		}
	}

	public static int checkPhuSong(char[][] map, int row, int col, int giaTriPhuSong, int M, int N) {
		int count = 0;// đếm số lượng hộ dân được phủ sóng
		// duyệt các vị trí xung quanh
		for (int i = 0; i <= giaTriPhuSong; i++) {
			for (int j = 0; j < 4; j++) {
				int tempX = dx[j] * i + row; // giá trị dx đầu bên trái * độ dài của điểm phủ sóng + giá trị
															// hàng ô hiện tại
				int tempY = dy[j] * i + col;
				// kiểm tra xem vị trí trên có nằm trong map không
				if (tempX >= 0 && tempX < M && tempY >= 0 && tempY < N) {
					if(map[tempX][tempY]== 'H') {
						map[tempX][tempY] = 'o';
						count++;
					}
				}
			}
		}
		//System.out.println(count);
		return count;

	}
}
