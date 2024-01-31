import java.util.Scanner;

public class NguoiDuLichThamLam {
    static int s[];
    static int f[];
    static int N;
    static int M;

    static void sx(){
        for(int i = 0; i < N; i++){
            f[i]+=M;
        }
        for(int i = 0; i <N - 1; i++){
            for(int j = i + 1; j < N; j++){
                if(f[i] > f[j]){
                    int tg = f[i];
                    f[i] = f[j];
                    f[j] = tg;

                    tg = s[i];
                    s[i] = s[j];
                    s[j] = tg;
                }
            }
        }
    }

    static int calSoChuyenDuLich(){
        int c = 0;
        int finish = 0;
        for(int i = 0; i < N; i++){
            if(s[i] >= finish){
                c++;
                finish=f[i];
            }
        }
        return c;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String tg[];

        N = 60;
        M = 1;
        s = new int[N];
        f = new int[N];
        tg = scan.nextLine().split(" ");
        System.out.println(tg.length);
        for(int i = 0; i < N;i ++){
            s[i] = Integer.parseInt(tg[i]);
        }
        tg = scan.nextLine().split(" ");
        for(int i = 0; i < N;i ++){
            f[i] = Integer.parseInt(tg[i]);
        }
        sx();
        System.out.println(calSoChuyenDuLich());

    }
}
