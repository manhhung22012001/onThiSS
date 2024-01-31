import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.Stack;

public class DayConTangDan {

    static int X[];
    static int l[];
    static int N;
    static int trace[];
    static int maxIndex;
    static int getMaxSubArrayLength(){
        l[0] = 1;
        int max = l[0];
        trace[0] = -1;
        for(int i = 1; i<N;i++){
            int tmp = 1;
            trace[i] = -1;
            for(int j = 0; j<i;j++){
                if(X[i] > X[j]){
                    if(tmp < l[j] + 1){
                        tmp = l[j] + 1;
                        trace[i] = j;
                    }
                }
            }
            l[i] = tmp;
            if(l[i] > max){
                maxIndex = i;
                max = l[i];
            }
        }
        return max;

    }

    public static void main(String[] args) {
        int tg[] = {3,2,1,5,21,100,102,103,128,16,12,21,26};
        X = tg;
        N = tg.length;
        l = new int[N];
        trace = new int[N];
        System.out.println(getMaxSubArrayLength());

        for(int i = 0; i < N;i++){
            System.out.print(l[i] + ",");
        }
        int c;
        for(int i = 0; i <N;i++){
            System.out.print(trace[i] +",");
        }
        System.out.println();
        Stack<Integer> stack = new Stack<>();
        stack.push(X[maxIndex]);
        do{
            c = trace[maxIndex];
            maxIndex = c;
            if(c!=-1){
                stack.push(X[c]);
            }
        }while(c != -1);;
        while (!stack.isEmpty()){
            System.out.print(stack.pop() +",");
        }

    }
}
