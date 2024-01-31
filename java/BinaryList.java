import java.util.ArrayList;

public class BinaryList {
    static int K;
    static int X[];
    static ArrayList<Integer> candidates(int k){
        ArrayList<Integer> ret = new ArrayList<>();
        if(k == 1) {
            ret.add(1);
        }else {
            ret.add(0);
            ret.add(1);
        }
        return ret;
    }

    static boolean isComplete(int k){
        if(k == K) return true;
        return false;
    }
    static void processConfiguration(){
        for(int i = 1; i<=K; i++){
            System.out.print(X[i]);
        }
        System.out.print(",");
    }
    static void attampt(int k){
        ArrayList<Integer> sk = candidates(k);
        for (Integer i : sk){
            X[k] = i;
            if(isComplete(k)){
                processConfiguration();
            }else {
                attampt(k + 1);
            }
        }
    }



    public static void main(String[] args) {
        K = 6;
        X = new int[K + 1];
        attampt(1);
    }
}
