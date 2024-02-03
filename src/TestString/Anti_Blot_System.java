package TestString;

import java.io.FileInputStream;
import java.util.Scanner;

public class Anti_Blot_System {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner=new Scanner(System.in);
		
		int T;
		T=scanner.nextInt();
		scanner.nextLine();
		for(int test=1;test<=T;test++) {
			scanner.nextLine();
			String S=scanner.nextLine();
			// tách phần của chuỗi 
			String[] part=S.split(" ");
			String[] apart=new String[4];
			
			// tìm vị trí của chữ machula
			int viTri=findAdress(part);
			//System.out.println("vi tri= "+viTri);
			// chuyển chuỗi thành số
			if(viTri==0) {
				int part2 =Integer.valueOf(part[2]);
				int part4 =Integer.valueOf(part[4]);
				int ans=part4-part2;
				System.out.println(ans+" "+part[1]+" "+part2+" "+part[3]+" "+part4);
			}else if(viTri==2) {
				int part0 =Integer.valueOf(part[0]);
				int part4 =Integer.valueOf(part[4]);
				int ans=part4-part0;
				System.out.println(part0+" "+part[1]+" "+ans+" "+part[3]+" "+part4);
			}else if(viTri==4) {
				int part0 =Integer.valueOf(part[0]);
				int part2 =Integer.valueOf(part[2]);
				int ans=part0+part2;
				System.out.println(part0+" "+part[1]+" "+part[2]+" "+part[3]+" "+ans);
			}
			
			
		}
		
	}
	public static int findAdress(String[] part) {
		for (int i = 0; i < part.length; i++) {
	        if (part[i].contains("machula")) {
	            return i;
	        }
	    }
	    return -1; // Nếu không tìm thấy "machula" trong mảng
	}

}
