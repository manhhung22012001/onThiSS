package TestString;

import java.io.FileInputStream;
import java.util.Scanner;

public class Tim_Kiem_String {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner = new Scanner(System.in);

		 for (int test = 1; test <= 10; test++) {
	            // Đọc số thứ tự của test case
	           	String test1 = scanner.nextLine();
	           	test=Integer.valueOf(test1);
	            
	            // Đọc chuỗi S1
	            String S1 = scanner.nextLine();
	            
	            // Đọc toàn bộ dòng, bao gồm cả khoảng trắng, cho chuỗi S2
	            String S2 = scanner.nextLine();

	            SoSanhChuoi(S1, S2, test);
	        }
		

	}

	public static void SoSanhChuoi(String S1, String S2, int test1) {
		int ans = 0;
		int lenS1=S1.length();
		int lenS2=S2.length();
		
		for (int i = 0; i <= lenS2 - lenS1; i++) {
		    boolean success = true;
		    for (int j = 0; j < lenS1; j++) {
		        if (S2.charAt(i + j) != S1.charAt(j)) {
		            success = false;
		            break;
		        }
		    }
		    if (success) {
		        ans++;
		    }
		}

		System.out.println("#" + (test1) + " " + ans);
	}

}
