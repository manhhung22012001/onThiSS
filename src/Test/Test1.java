package Test;

import java.io.FileInputStream;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("input.txt"));
		// căn bậc 2
		Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt(); // Số lượng test case
        int[] arr = new int[T];

        for (int i = 0; i < T; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < T; i++) {
            System.out.println("#" + (i + 1) + " " + (int) Math.sqrt(arr[i]));
        }

        scanner.close();
		
	}

}
