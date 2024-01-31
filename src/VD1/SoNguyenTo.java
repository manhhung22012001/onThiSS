package VD1;

import java.util.ArrayList;
import java.util.Scanner;

public class SoNguyenTo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		nhapmang();
	}
	public static void nhapmang() {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		System.out.print("Nhập số phần tử của mảng: ");
		int soPhanTu = scanner.nextInt();
		
		for(int i = 0; i< soPhanTu; i ++) {
			System.out.print("Nhập Phần tử thứ "+(i+1)+": ");
			int so = scanner.nextInt();
			
			arr.add(so);
			
		}
		System.out.println("Mảng vừa nhập là: "+ arr);
		// kiểm tra số nguyên tố
		for(int i = 0; i< arr.size(); i ++) {
			if(arr.get(i) == 1) {
				System.out.println("Số 1 là số nguyên tố.");
			}
			else if(arr.get(i) % Math.sqrt(arr.get(i)) == 0) {
				System.out.println("Số "+ arr.get(i)+" không là số nguyên tố.");
				
			}
			else {
				System.out.println("Số "+ arr.get(i)+" là số nguyên tố.");
				
			}
			
			
		}
	}
	

}
