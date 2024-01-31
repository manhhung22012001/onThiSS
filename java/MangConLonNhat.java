import java.util.Scanner;

public class MangConLonNhat {
    static Integer X[];
    static int W[];
    static int max = Integer.MIN_VALUE;
    static int N;
    static int start;
    static int finish;
    static int getTrongLuongLonNhat(){
        W[0] = X[0];
        max = W[0];
        start = 0; finish = 0;
        for(int i = 1; i < N; i++){
            if(W[i - 1] < 0){
                W[i] = X[i];
                start = i;
            }else {
                W[i] = W[i-1]+X[i];
            }
            if(W[i]>max){
                finish = i;
                max = W[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        String arr[] = scan.nextLine().split(",");
//        N=arr.length;
//        X = new Integer[N];
//        for(int i = 0; i < N;i++){
//            X[i] = Integer.parseInt(arr[i]);
//        }
        Integer tg[] = {4,-12,-100,19,3,5,12,-99,90,23,-16,111,-11,8,2,-14,21};
        X = tg;
        N = tg.length;
        W = new int[N];
        System.out.println(getTrongLuongLonNhat());
        for(int i = 0; i< N;i++){
            System.out.print(W[i]+",");
        }
        System.out.println("\n" + start +","+finish);
    }

}
