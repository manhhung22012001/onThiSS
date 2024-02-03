package TestString;

import java.io.FileInputStream;
import java.util.Scanner;

public class To_and_For {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner scanner = new Scanner(System.in);

		while (true) {
			int col=scanner.nextInt();
			if(col==0) {break;}
			String S= scanner.next();
			MaHoa(col,S);
			
		}

	}
	public static void MaHoa(int col, String S) {
		
		int row=S.length()/col;
		int index=0;
		//System.out.print("row= "+row+" cOL="+col);
		char[][] maTrix=new char[row][col];
		for(int i=0;i<row;i++) {
			if(i%2==0) {
				for(int j=0;j<col;j++) {
					maTrix[i][j]=S.charAt(index++);
				}
			}else {
				for(int j=col-1;j>=0;j--) {
					maTrix[i][j]=S.charAt(index++);
				}
			}
		}
		int index1=0;
		char[] chuoiDaDuocMaHoa= new char[row*col];
		for(int j=0;j<col;j++) {
			for(int i=0;i<row;i++) {
				chuoiDaDuocMaHoa[index1++]=maTrix[i][j];
			}
		}
		String ans= new String(chuoiDaDuocMaHoa);
		System.out.println(ans);
		
				
	}

}
