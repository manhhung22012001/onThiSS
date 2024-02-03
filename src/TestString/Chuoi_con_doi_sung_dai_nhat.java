package TestString;

import java.io.FileInputStream;
import java.util.Scanner;

public class Chuoi_con_doi_sung_dai_nhat {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng mới sau số lượng test case

        for (int test = 1; test <= T; test++) {
            String input = scanner.nextLine();
            int result = findLongestSymmetricSubstring(input);
            System.out.println("#" + test + " " + result);
        }
    }

    public static int findLongestSymmetricSubstring(String s) {
        int maxLength = 1;  // Mặc định là 1 vì mỗi ký tự là một chuỗi đối xứng

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);        // Chuỗi con đối xứng với trung điểm là 1 ký tự
            int len2 = expandAroundCenter(s, i, i + 1);    // Chuỗi con đối xứng với trung điểm là 2 ký tự

            int currentLength = Math.max(len1, len2);      // Chọn độ dài lớn nhất
            maxLength = Math.max(maxLength, currentLength); // So sánh với độ dài hiện tại
        }

        return maxLength;
    }

    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // Trả về độ dài của chuỗi con đối xứng
        return right - left - 1;
    }

}
