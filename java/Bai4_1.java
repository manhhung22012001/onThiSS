public class Bai4_1 {
    static int i = 0;
    static long M[][]; //ma tran luu gia tri cua C[i][j]
    static int HoiCham1(int m, int n){
        System.out.println(m + "," + n);
        if(m == 0){
            return n + 1;
        }
        if(m > 0 && n == 0){
            return HoiCham1(m-1, 1);
        }
        int c = HoiCham1(m, n-1);
        return HoiCham1(m-1, c);
    }
    static int HoiCham2(int k, int n){
        if(k ==1 && n ==2){
            i++;
        }
        if(k==n || k==0) return 1;
        return HoiCham2(k-1, n-1) + HoiCham2(k, n-1);
    }
    static long HoiCham2CaiTien(int k, int n){
        if(k==0 || k == n) M[k][n] = 1;
        else if(M[k][n] < 0){
//            System.out.println(k + "," +n);
            M[k][n] = HoiCham2CaiTien(k-1, n-1) + HoiCham2CaiTien(k, n-1);
        }
        return M[k][n];
    }
    public static void main(String[] args) {
        M = new long[100][100];
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100;j++){
                M[i][j] = -1;
            }
        }
        System.out.println(HoiCham2CaiTien(50,60));
    }
}
