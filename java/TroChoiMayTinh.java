import java.util.Arrays;
import java.util.Scanner;

public class TroChoiMayTinh {
    static Integer me[];
    static Integer computer[];
    static boolean visited[];
    static int N;

    static void sx(){
        Arrays.sort(me);
        Arrays.sort(computer);
    }

    static int calWin(){
        int count = 0;
        int index = 0;
        for(int i = 0; i < N;i++){
            for(int j = index; j < N; j++){
                if(computer[i] < me[j]){
                    count++;
                    index = j + 1;
                    break;
                }
                if(j == N - 1){
                    return count;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        N = 8;
        Scanner scan = new Scanner(System.in);
        String arrStr[];
        computer = new Integer[N];
        me = new Integer[N];
        arrStr = scan.nextLine().split(",");
        for(int i =0; i< N;i++){
            computer[i] = Integer.parseInt(arrStr[i]);
        }
        arrStr = scan.nextLine().split(",");
        for(int i =0; i< N;i++){
            me[i] = Integer.parseInt(arrStr[i]);
        }
        sx();
        System.out.println(calWin());
    }
}
