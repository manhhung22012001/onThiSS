package VD1;

import java.util.Scanner;

public class CB6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Nhập số : ");
		int product = scanner.nextInt();
		int kq= timSoChuSo(product);
		System.err.println("Other"+kq);
	}
	public static int timSoChuSo(int product) {
		 if (product == 0) {
	            return 10;
	        }
		 int kq=0;
		 int kq1=0;
		 for(int i=1; i<=9; i++) {
			if(product%i==0) {
				// cho lặp đến cuối để lấy số chia hết to nhất là other product xong nhân nó vs 10 và cộng với i
				int otherProduct = product/i;
				kq=otherProduct;
				kq1=i;
				System.err.println("i "+i);
				if(otherProduct >=1 && otherProduct<=9) {
					return i*10+otherProduct;
				}
			} 
			 
		 }
		 return -1;
				 
	}
}
