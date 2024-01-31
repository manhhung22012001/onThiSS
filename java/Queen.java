import java.util.ArrayList;

public class Queen {
    static int N;
    static int X[];
    static int col;
    static int value[];
    static int count = 0;
    static boolean isComplete(int k){
        if(k == N - 1){
            return true;
        }else
            return false;
    }
    static void processConfiguration(){
        for(int i = 0; i < N; i++){
            System.out.print(X[i]);
        }
        System.out.println();
    }
    static ArrayList<Integer> candidates(int k){
        ArrayList<Integer> ret = new ArrayList<>();
        for(int v = 0; v < N; v++){
            if(k == 0) ret.add(v);
            else {
                boolean not_configure = true;
                for(int i = 0; i < k; i++){
                    if(v == X[i] || Math.abs(v - X[i]) == Math.abs(k - i)){
                        not_configure = false;
                        break;
                    }
                }
                if(not_configure) ret.add(v);
                if( k == col){
                    boolean print = true;
                    for(int i = 0; i < col ; i++){
                        if(!(X[i] == value[i] && not_configure)){
                            print = false;
                            break;
                        }
                    }
                    if (print) System.out.print(v + ",");
                }
            }
        }
        return ret;
    }
    static void Try(int k){

        ArrayList<Integer> sk = candidates(k);
        for (Integer v : sk){
            X[k] = v;
            if(isComplete(k)){
                count++;
//                processConfiguration();
            }else {
                Try(k + 1);
            }
        }
    }

    public static void main(String[] args) {

        N = 8;
        col = 3;
        X = new int[N + 1];
        int tg[] = {0,4,7};
        value = tg;
        Try(0);
        System.out.println();
        System.out.println(count);
    }
}
