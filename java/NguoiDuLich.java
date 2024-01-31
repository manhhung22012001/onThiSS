import java.util.ArrayList;

public class NguoiDuLich {
    static int BEST = Integer.MAX_VALUE;
    static int c[][];
    static int X[];
    static int N;
    static int count = 0;
    static boolean visited[];
    static int cmin;
    static int value[];
    static int kS;
    static ArrayList<Integer> candidates(int k){
        ArrayList<Integer> ret = new ArrayList<>();
        if(k == 1){
            ret.add(1);
        }else {
            for(int i = 1; i<=N;i++){
                if(!visited[i]){
                    ret.add(i);
                }
            }
        }
        return ret;
    }
    static void processConfiguration(){
        for(int i = 1; i<=N;i++){
            System.out.print(X[i] + ",");
        }
        System.out.println("\n" + BEST);
    }
    static boolean isComplete(int k){
        if(k==N) return true;
        return false;
    }

    static int quality(){
        int len = 0;
        for(int i = 1; i<=N-1; i++){
            len += c[X[i]][X[i+1]];
        }
        len += c[X[N]][1];
        return len;
    }

    static int estimate(int k){
        int len = 0;
        for(int i = 1; i < k; i++){
            len += c[X[i]][X[i+1]];
        }
        len += (N-k+1)* cmin;
        boolean printValue = true;
        if(k == kS){
            for(int i = 1; i<=kS; i++){
                if(X[i] != value[i]){
                    printValue = false;
                }
            }
        }else {
            printValue = false;
        }
        if(printValue){
            System.out.println("length: " + len);
        }
        return len;
    }
    static void Try(int k){
        ArrayList<Integer> sk = candidates(k);
        for(Integer v : sk){
            X[k] = v;
            visited[v] = true;
            if(isComplete(k)){
                int q = quality();
                if( q < BEST) {
                    BEST = q;
                    processConfiguration();
                }
            }else {
                if (estimate(k) < BEST){
                    Try(k + 1);
                }
            }
            visited[v] = false;

        }
    }
    public static void main(String[] args) {
        int tg[][] = {
                {0, 0, 0, 0, 0},
                {0, 0, 3, 7, 4},
                {0, 3, 0, 1, 2},
                {0, 7, 1, 0, 5},
                {0, 4, 2, 5, 0}
        };
        cmin = 1;
        kS = 2;
        int tg2[] = {0, 1, 2};
        value = tg2;
        N = 4;
        c = tg;
        visited = new boolean[N + 1];
        X = new int[N + 1];
        Try(1);



    }
}
