package TestArray;

import java.io.FileInputStream;
import java.util.Scanner;

public class Queue_Rookie {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		 Scanner scanner = new Scanner(System.in);
	        int T = scanner.nextInt(); // Số trường hợp kiểm thử

	        for (int t = 0; t < T; t++) {
	            int N = scanner.nextInt(); // Số người đứng xếp hàng trong trường hợp kiểm thử
	            int[] chieuCao = new int[N];
	            int[] vitri = new int[N];
	            int[] ketqua = new int[N];

	            // Đọc chiều cao của mỗi người
	            for (int i = 0; i < N; i++) {
	            	chieuCao[i] = scanner.nextInt();
	            }

	            // Đọc số người cao hơn đứng trước từng người
	            for (int i = 0; i < N; i++) {
	            	vitri[i] = scanner.nextInt();
	            }
	           
	            // Xử lý trường hợp kiểm thử
	            for (int i = 0; i < N; i++) {
	                int count = 0;
	                for (int j = 0; j < N; j++) {
	                    if (count == vitri[i] && ketqua[j] == 0) {
	                    	 //System.out.println("count= "+ count+" vi tri["+i+"]= "+vitri[i]+" ket qua["+j+"]= "+ketqua[j]);
	                    	 ketqua[j] = chieuCao[i];
	                        //System.out.println("result["+j+"]="+ketqua[j]);
	                        break;
	                    }
	                    if (ketqua[j] == 0 || ketqua[j] > chieuCao[i]) {
	                    	 //System.out.println("count= "+ count+" chieu cao["+i+"]= "+ chieuCao[i]+" ket quả["+j+"]= "+ketqua[j]);
	                        count++;
	                    }
	                }
	            }

	            // In kết quả cho trường hợp kiểm thử
	            for (int i = 0; i < N; i++) {
	                System.out.print(ketqua[i] + " ");
	            }
	            System.out.println();
	        }

	}

}
