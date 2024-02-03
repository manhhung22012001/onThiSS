package TestString;

import java.io.FileInputStream;
import java.util.Scanner;

public class Dem_Chuoi_Con_Doi_Sung {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng mới sau số lượng test case

        for (int test = 1; test <= T; test++) {
            String input = scanner.nextLine();
            int result = countSymmetricStrings(input);
            System.out.println("#" + test + " " + result);
        }
    }

    public static int countSymmetricStrings(String input) {
        int count = 0;
        int n = input.length();

        for (int i = 0; i < n; i++) {
            // Đếm chuỗi con đối xứng với trung điểm là ký tự i (nếu độ dài của chuỗi con là lẻ)
            count += countPalindromes(input, i, i);

            // Đếm chuỗi con đối xứng với trung điểm là giữa ký tự i và i+1 (nếu độ dài của chuỗi con là chẵn)
            count += countPalindromes(input, i, i + 1);
        }

        return count;
    }

    public static int countPalindromes(String s, int left, int right) {
        int count = 0;
        System.out.println("left ="+left+"right="+right);
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // Ký tự trái và phải giống nhau, tăng số lượng đối xứng và mở rộng phạm vi
            count++;
            left--;
            right++;
        }

        return count;
    }
    
}
