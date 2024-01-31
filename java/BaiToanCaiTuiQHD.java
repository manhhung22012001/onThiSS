import java.util.ArrayList;
import java.util.List;

public class BaiToanCaiTuiQHD {
    static int N;
    static int S;
    static int w[];
    static int v[];
    static List<Integer> list;
//    static int F[][];

    static int[][] getF(){
        int F[][] = new int[N+1][S+1];
        for(int i = 0; i<N+1;i++){
            F[i][0] = 0;
        }
        for(int i = 0; i<S+1;i++){
            F[0][i] = 0;
        }

        for(int k = 1; k<=N;k++){
            for(int s =1; s<=S;s++){
                if(s - w[k] >=0 ){
                    if(F[k-1][s] > F[k-1][s-w[k]] + v[k]){
                        F[k][s] = F[k-1][s];
                    }else {
                        F[k][s] = F[k-1][s-w[k]] + v[k];
                    }
                }else {
                    F[k][s] = F[k-1][s];
                }
            }
        }
        return F;
    }



    public static void main(String[] args) {
        int tg[] = {0, 1,2,4,3,5};
        w = tg;
        int tg2[] = {0,3,4,3,7,3};
        v = tg2;
        N = 5;
        S = 6;
        list = new ArrayList<>();
        int arr[][] = getF();
        for(int i = 0; i<=N;i++){
            for (int j = 0; j<=S;j++){
                System.out.print(arr[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println(arr[N][S]);
        int k = N, l = S;
        while (k != 0 && l!=0){
            if(arr[k][l] != arr[k-1][l] ){
                list.add(k);
                l = l - w[k];
                k = k-1;
            }else {
                k = k-1;
            }
        }
        for(int i: list){
            System.out.print(i + ",");
        }
    }
}
