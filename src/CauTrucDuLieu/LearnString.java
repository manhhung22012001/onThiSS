package CauTrucDuLieu;

import java.util.Scanner;

public class LearnString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		String s = "hello world";
		System.out.println(s);

		char ch[] = { 'h', 'u', 'n', 'g' };
		String hung = new String(ch);// chuyển mảng thành chuỗi
		System.out.println(ch);
		System.out.println(hung);

		// nối chuỗi mới vào sau chuỗi s dùng concat
		String[] newString = new String[5];
		for (int i = 0; i < 5; i++) {
			System.out.print("Ký tự thứ " + i + " là: ");
			newString[i] = scanner.nextLine();

		}
		// chuyển mảng nhập vào thành chuỗi
		// cách 1
		String c1 = "";
		// for(int i=0; i< 5; i++){
		// c1+=newString[i];

		// }
		// System.out.println("chuỗi sau khi nhập là: "+c1);

		// nối
		// s=s.concat(c1);
		// System.out.println("chuỗi s cũ là: "+ s+" chuỗi s mới sau khi nối thêm là:
		// "+s.concat(c1));

		// cách 2 dùng stringbuilder
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(s);
		// thêm từng phần tử vào stingbuilder sau đó chuyển qua sting bằng .toString
		for (int i = 0; i < 5; i++) {
			stringbuilder.append(newString[i]);

		}

		c1 = stringbuilder.toString();
		System.out.println("chuỗi s cũ là: " + s + " chuỗi s mới sau khi nối thêm là: " + c1);
		int dem=0;
		for (int i = 0; i <c1.length() ; i++) {
			if(c1.charAt(i)== ' ') {
			dem+=1;	
			}
		}
		System.out.print("số ký tự cách là: "+dem);
	}

}
