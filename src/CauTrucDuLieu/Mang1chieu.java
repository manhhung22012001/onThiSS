package CauTrucDuLieu;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Mang1chieu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(2);
		arr.add(3);
		arr.add(5);
		arr.add(23);
		arr.add(7);
		arr.add(9);
		arr.add(12);
		arr.add(2);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập vị trí để tìm kiếm phần tử: ");
		int viTri= scanner.nextInt();
		int viTri1=timKiemPhanTuTheoViTri(viTri, arr);// hàm tìm kiếm giá trị theo vị trí
		System.out.println("Vị trí "+viTri+" có phần tử mang giá trị là: "+viTri1);
		System.out.println("Mảng hiện tại là: "+arr);
		int vitridoi1=2;
		int vitridoi2=4;
		doiViTri(vitridoi1, vitridoi2, arr);// đổi vị trí
		// trèn phần tử trên mảng 1 chiều
		int[] a= {1,2,3,4,5};
		int[] b= new int[vitridoi2];
		trenPhanTu(a) ;
			
			
		
	}
	
	public static int timKiemPhanTuTheoViTri(int a,ArrayList<Integer> arr) {
		for(int i = 0 ; i<= arr.size(); i++) {
			if(i+1 == a) {
				return arr.get(i);
				
			}
			
		}
		return -1;
	}
	public static void doiViTri(int vitridoi1, int vitridoi2, ArrayList<Integer> arr) {
		
		
		for(int i = 0 ; i < arr.size(); i++) {
			for(int j=i+1; j< arr.size(); j++) {
				if(i+1 == vitridoi1 && j+1 == vitridoi2) {
					int tg= arr.get(i);
					arr.set(i, arr.get(j));
					arr.set(j, tg);
				}				
			}
		}
		System.out.println("Mảng hiện tại sau khi đổi vị trí thứ 2 và 4 là: "+arr);
		
	}
	public static void trenPhanTu(int[] a) {
		int index = 4;
        int giaTri = 40;

        // Tăng kích thước cho mảng
        a = Arrays.copyOf(a, a.length + 1);
        for(int i = 0; i<a.length; i ++) {
        	System.out.println("i= "+i+" thì giá trị = "+a[i]);
        	
        }
        // Lùi giá trị
        for (int i = a.length - 1; i > index-1; i--) {
        	 a[i] = a[i - 1];
          
            
        }

        // Gán giá trị mới
        a[index-1] = giaTri;

        // Hiển thị mảng mới
        System.out.print("Mảng mới sau khi trèn: ");
        for (int i : a) {
            System.out.print(i + " ");
        }
		
	}
	
}
