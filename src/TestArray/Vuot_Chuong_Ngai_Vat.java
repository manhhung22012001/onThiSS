package TestArray;

import java.io.FileInputStream;
import java.util.Scanner;

public class Vuot_Chuong_Ngai_Vat {
	public static final int[] AmoveX = { +1, -1, +1, -1 };// đi chéo
	public static final int[] AmoveY = { +1, +1, -1, -1 };// đi chéo
	public static final int[] AmoveXY = { +1, -1 };// lên xuống sang bên
	public static int ans;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner = new Scanner(System.in);
		int T, N, x, y;
		T = scanner.nextInt();
		for (int tescase =1; tescase <= T; tescase++) {
			N = scanner.nextInt();
			x = scanner.nextInt();
			y = scanner.nextInt();
			ans=0;
			int[][] matrix = new int[N][N];// ma trận số
			boolean[][] Check = new boolean[N][N];// ma trận điểm cuối
			// nhập ma trận
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = scanner.nextInt();
				}
			}
			
			// duyệt điểm
			TinhTong(matrix, Check, x, y, N);
			//System.out.println("Count="+count);
			System.out.println("#"+tescase+" "+ans);
		}

	}

	public static void TinhTong(int[][] matrix, boolean[][] Check, int x, int y, int N) {
		
		int j = 0;
		int[] giatri = new int[8];// mảng lưu giá trị
		int[] vitriX=new int[8];// mảng lưu vị trí của điểm xung quanh thỏa mãn
		int[] vitriY=new int[8];
		Check[x][y]=true;
		// nhìn trên dưới và ngang
		for (int i = 0; i < 2; i++) {
			int newRow = x + AmoveXY[i];
			int newCol = y + AmoveXY[i];
			if (newRow >= 0 && newRow < N && !Check[newRow][y]) {
				giatri[j] = matrix[newRow][y];
				vitriX[j]=newRow;
				vitriY[j]=y;
				j++;
			}
			if (newCol >= 0 && newCol < N &&!Check[x][newCol]) {
				giatri[j] = matrix[x][newCol];
				vitriX[j]=x;
				vitriY[j]=newCol;
				j++;
			}
		}
		// nhìn chéo
		for(int i=0;i<4;i++) {
			int newRow = x + AmoveX[i];
			int newCol = y + AmoveY[i];
			if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N &&!Check[newRow][newCol]) {
				giatri[j] = matrix[newRow][newCol];
				vitriX[j]=newRow;
				vitriY[j]=newCol;
				j++;
			}
			
		}
		int minAround=99999;
		int vitri=0;
		//System.out.println("matrix[x][y]="+matrix[x][y]);
		for (int i = 0; i < 8; i++) {
			if(giatri[i]<minAround && giatri[i] !=0 && giatri[i]>matrix[x][y]) {
				minAround=giatri[i];
				vitri=i;
			}
		}
		//System.out.println("Min ="+minAround+"tai vi tri x="+vitriX[vitri]+" y= "+vitriY[vitri]);
		if(matrix[x][y]<matrix[vitriX[vitri]][vitriY[vitri]] && !Check[vitriX[vitri]][vitriY[vitri]]) {
			
			x=vitriX[vitri];
			y=vitriY[vitri];
			ans++;
			TinhTong(matrix,Check,x,y,N);
			//System.out.println("Count="+ans);
		}
		else {return;}
		
	}

}
