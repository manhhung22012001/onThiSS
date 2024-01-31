package VD1;
import java.util.ArrayList;
import java.util.Scanner;

public class PvanCtyCoLong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world");
		nhapmang();
	}
	public static void nhapmang() {
		Scanner sncnner=new Scanner(System.in);
//		System.out.print("Nhap so phan tư cua mang: ");
//		int soPhanTu = sncnner.nextInt();
//		System.out.print("Nhap gia tri mang:");
		
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(2);
		arr.add(3);
		arr.add(5);
		arr.add(3);
		arr.add(7);
		arr.add(9);
		arr.add(12);
		arr.add(2);
		
		System.out.print("Nhap so can kiem tra: ");
		int soPhanTu = sncnner.nextInt();
		
		int dem=-1;
		for(int i=0; i< arr.size(); i++) {
			if(soPhanTu == arr.get(i)) {
				dem=i;
//				break;
	            }
	        }

	        if (dem != -1) {
	            System.out.println("Vi tri cuoi cung cua " + soPhanTu + " trong mang la vi tri thu " + (dem + 1));
	        } else {
	            System.out.println(soPhanTu + " khong xuat hien trong mang.");
	        }

	        // Đóng Scanner sau khi sử dụng
	        sncnner.close();
		
		
	}

}
