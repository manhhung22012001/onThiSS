package VD1;

import java.util.Scanner;

public class GiaiThua {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Nhập số giai thừa cần tính: ");
		int so = scanner.nextInt();
		int giaithua= 1;
		for(int i = 1; i <= so; i++) {
			giaithua*=i;
		}
		
		while(giaithua % 10 ==0 && giaithua !=0) {
			giaithua=giaithua/10;
		}
		int Socuoi=laySocuoi(giaithua);
		System.out.print("SỐ CUỐI LÀ: "+ Socuoi);
		
	}
	public static int laySocuoi(int a) {
		return a%10;
	}

}
