package TestArray;

import java.io.FileInputStream;
import java.util.Scanner;

public class Phan_Tich_Rem_Cua1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int test = 0; test < T; test++) {
			int M = scanner.nextInt();
			int N = scanner.nextInt();
			int nRows = 5 * M + 1;
			int nColumns = 5 * N + 1;
			 // Đọc dòng trống để bỏ qua
            scanner.nextLine();
			char[][] matrix = new char[nRows][nColumns];
			for (int i = 0; i < 5 * M + 1; i++) {
				String row=scanner.next();
                matrix[i] = row.toCharArray();
            }
			// In ra ma trận để kiểm tra
//            for (int i = 0; i < nRows; i++) {
//                for(int j = 0; j < nColumns; j++) {
//                    System.out.print(matrix[i][j] + "   ");
//                }
//                System.out.println();
//            }
			//
            int[] result = {0,0,0,0,0};
            result=Slove(result,matrix,M,N);
            System.out.print("#"+(test+1)+" ");
            for (int i = 0; i < 5; i++) {System.out.print(result[i] + " ");}
            System.out.println();
           
		}
	}
	public static int[] Slove(int[] result, char[][] matrix, int M, int N) {
		 for (int i = 1; i <= M; i++) {
	            for (int j = 1; j <= N; j++) {
	            	//System.out.println(matrix[i][j]+"     ");
	                int type = getType(matrix,i, j);
	               result[type] += 1;
	            }
	        }
		return result;
	}
	public static int getType( char[][] matrix, int r, int c) {
		int rows = 5 * r ;
        int columns = 5 * c ;
       //System.out.println("Nhan duoc r="+r+" c="+c+" sau khi cong row="+rows+" col="+columns);
        int result = 0;
        for (int i = rows - 4; i < rows; i++) {
            if (matrix[i][columns - 4] == '.') {
            	//System.out.println("vi tri duyet1 r="+i+" c="+(columns-4)+" gia tri duyet="+matrix[i][columns - 4]);
                
            } else {
            	//System.out.println("vi tri duyet2 r="+i+" c="+(columns-4)+" gia tri duyet="+matrix[i][columns - 4]);
                result += 1;
            }
        }
        //System.out.println("result= "+result);
        return result;
		
	}

}
