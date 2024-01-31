package VD1;

import java.util.ArrayList;
import java.util.Scanner;

public class CB2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập số cần tính: ");
		int so = scanner.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		
		while(so>1) {
			int sum =0;
			int k=2;
			if(so % k == 0) {
				sum+=k;
				so=so/k;
				
			}
			else {k++;}
			System.out.print(12+ " co tong bang :"+ sum);
		}
			
		
	}

}
