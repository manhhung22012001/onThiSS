import java.util.Scanner;

public class MuaHoaQua {
    static Integer w[];
    static Integer p[];
    static Integer avg[];
    static int N;
    static int W;

    static void sx(){
        for(int i = 0; i< N; i++){
            avg[i] = p[i] / w[i];
        }
        for(int i = 0; i < N - 1; i++){
            for (int j = i + 1; j < N; j++){
                if(avg[i] < avg[j]){
                    int tg = w[i];
                    w[i] = w[j];
                    w[j] = tg;

                    tg = p[i];
                    p[i] = p[j];
                    p[j] = tg;

                    tg = avg[i];
                    avg[i] = avg[j];
                    avg[j] = tg;
                }
            }
        }
    }

    static int calMaxPrice(){
        int max = W;
        int price = 0;
        for(int i = 0; i<N; i++){
            int tg = Math.min(max, w[i]);
            price+=tg*avg[i];
            max-=tg;
            System.out.println(tg);
            if(max == 0){
                break;
            }
        }
        return price;
    }

    public static void main(String[] args) {
        N = 13;
        W = 38;
        w = new Integer[N];
        p = new Integer[N];
        avg = new Integer[N];
        Scanner scan = new Scanner(System.in);
        String arrStr[];
        arrStr = scan.nextLine().split(" ");
        for(int i = 0; i < N; i++){
            w[i] = Integer.parseInt(arrStr[i]);
        }
        arrStr = scan.nextLine().split(" ");
        for(int i = 0; i < N; i++){
            p[i] = Integer.parseInt(arrStr[i]);
        }
        sx();
        System.out.println(calMaxPrice());
    }
}
