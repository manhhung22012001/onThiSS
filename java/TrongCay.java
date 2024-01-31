import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TrongCay {
    static Integer X[];
    static int N;
    static int calNgayMoTiec(){
        int n = 0;
        for(int i = 1; i <= N;i++){
            int k = i + X[i];
            n = Math.max(n, k);
        }
        return n;
    }


    public static void main(String[] args) {
        Integer x[] = {9999999, 32,12,4,5,32,44,21,17};
        X = x;
        N = 6;
        Arrays.sort(X, Collections.reverseOrder());
        System.out.println(calNgayMoTiec() + 1);
    }
}
