public class CayRuongQHD {

    static int X[];
    static int F[];
    static int N;
    static int K;
    static int max;
    static int start;
    static int finish;

    static void getMaxIncome(){
        for(int i = 0; i <N;i++){
            X[i]-=K;
        }

        F[0] = X[0];
        max = F[0];
        start=0;
        finish=0;
        for(int i = 1; i<N;i++){
            if(F[i-1] < 0 ){
                F[i] = X[i];
                start=i;
            }else {
                F[i] = X[i] + F[i-1];
            }
            if(F[i] > max){
                max = F[i];
                finish=i;
            }
        }
    }



    public static void main(String[] args) {
        int tg[] = {2,9,8,6,2};
        N = 5;
        K = 5;
        X = tg;
        F = new int[N];
        getMaxIncome();
        System.out.println(max);
        System.out.println(start +", " + finish);
    }
}
