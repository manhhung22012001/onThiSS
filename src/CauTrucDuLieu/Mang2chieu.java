package CauTrucDuLieu;

import java.util.Scanner;

public class Mang2chieu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arrA = {
				{1,44,12,78},
				{15,17,19,22},
				{1,5,7,9,10},
				{6,99,32,15},
				{44,22,7,9}
				
		};
		Scanner scanner= new Scanner(System.in);
		int[][] arrB = new int[4][4];
//		System.out.println("Nhập giá trị phần tử của mảng B");
//		for(int i=0; i<4; i++) {
//			for(int j=0; j<4; j++) {
//				System.out.println("["+i+"]["+j+"]= ");
//				arrB[i][j]=scanner.nextInt();				
//			}			
//		}
		System.out.println("Mảng A là: ");
		hienThiMang(arrA);
		System.out.println("Số hàng Mảng A là: "+ arrA.length);
		System.out.println("Số cột Mảng A là: "+ arrA[0].length);
//		System.out.println("Mảng B là: ");
//		hienThiMang(arrB);
		
		// thêm hàng
		int[] newRow= {1,5,7,9};
		int[][] hangSauKhiThem=ThemHang(arrA, newRow);
		
		// xóa cột 
		int cotCanXoa=2;
		Xoacot(cotCanXoa, arrA);
		
	}
	public static void hienThiMang(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<4; j++) {
				System.out.print(arr[i][j]+ "\t");
								
			}	
			System.out.println("");
		}
	}
	public static int[][] ThemHang(int[][] arr, int[] newRow) {
		int [][] newMatrix = new int[arr.length+1][arr[0].length];
		System.out.println("Số hàng Mảng A là: "+ newMatrix.length);
		System.out.println("Số cột Mảng A là: "+ newMatrix[0].length);
		// trèn vào cuối
		for(int i=0; i< arr.length; i++) {
			newMatrix[i] = arr[i];
			
		}
		newMatrix[arr.length]= newRow;
		// trèn  vào vị trí bất kì
		int viTriThem= 2;
		int [][] newMatrix1 = new int[arr.length+1][arr[0].length];
		for(int i=0; i< arr.length+1; i++) {
			if(i<viTriThem-1) {
				newMatrix1[i] = arr[i];
				System.out.println("i1= : "+i);
				
			}
			else if(i == viTriThem-1) {
				newMatrix1[i]= newRow;
				System.out.println("i2= : "+i);
			}
			else {
				newMatrix1[i] = arr[i-1];
				System.out.println("i3= : "+i);
			}
				
		}
		System.out.println("Mảng newMatrix là: ");
		hienThiMang(newMatrix);
		System.out.println("Mảng newMatrix1 là: ");
		hienThiMang(newMatrix1);
		return arr;
	}
	public static void Xoacot(int cotCanXoa, int[][] arr) {
		
		
	}
}
