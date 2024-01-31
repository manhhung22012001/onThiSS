package TestArray;

import java.io.FileInputStream;
import java.util.Scanner;

public class BTFNUM_SoDep {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner = new Scanner(System.in);
		int TestCase, n, m;
		TestCase = scanner.nextInt();
		for (int test = 0; test < TestCase; test++) {
			// nhập số lượng các số đẹp
			n = scanner.nextInt();
			// nhập số lượng các số đẹp yêu cầu có trong mã sản phẩm (m số).
			m = scanner.nextInt();
			// nhập vào các số đẹp
			int[] beautifulNumbers = new int[n];
			for (int i = 0; i < n; i++) {
				beautifulNumbers[i] = scanner.nextInt();
			}

			// nhập vào x,y
			int x = scanner.nextInt(); // giới hạn dưới
			int y = scanner.nextInt(); // giới hạn trên
			int result = 0;
			int count =0;
			for (int xy = x; xy <= y; xy++) {
				if(DemSoDep(beautifulNumbers,xy,m)) {
					count++;
				}
			}
			System.out.println("#" + (test+1) + " " + count);
			
		}
	}

	public static boolean DemSoDep(int[] beautifulNumbers, int xy,int m) {
			int count=0;
			while(xy>0) {
				int temp = xy%10;
				if(CheckSoDep(beautifulNumbers,temp)) {
					count++;
					if(count == m) {
						return true;
					}
				}
				xy/=10;
			}
			return false;
	}
	public static boolean CheckSoDep(int[] beautifulNumbers, int temp) {
		for(int i=0;i<beautifulNumbers.length;i++) {
			if(temp==beautifulNumbers[i]) {
				return true;
			}
				
		}
		return false;
	}
}
