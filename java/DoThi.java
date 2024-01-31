import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DoThi {
    static Integer X[][];
    static int color[];
    static int N;
    static int d[];

    static void DFS_Stack(int u){
        Stack<Integer> stack = new Stack<>();
        stack.push(u);
        color[u] = 1;
        while (!stack.isEmpty()){
            int v = stack.pop();
            System.out.print(v + ",");
            for(int i = 1; i <=N;i++){
                if(X[v][i] == 1){
                    if(color[i] == 0){
                        color[i] = 1;
                        stack.push(i);
                    }
                }
            }
        }
    }

    static void BFS(int u){
        Queue<Integer> queue = new LinkedList<>();
        color[u] = 1;
        queue.add(u);
        d[u] = 0;
        while (!queue.isEmpty()){
            u = queue.poll();
            System.out.print(u +",");
            for(int v = 1; v <=N;v++){
                if(X[u][v] == 1){
                    if(color[v] == 0){
                        d[v] = d[u] + 1;
                        color[v] = 1;
                        queue.add(v);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Integer tg[][] = {
                {0,0,0,0,0,0,0,0},
                {0,0,1,1,0,0,0,0},
                {0,1,0,1,0,0,0,1},
                {0,1,1,0,0,1,0,1},
                {0,0,1,0,0,0,1,1},
                {0,0,0,1,0,0,1,1},
                {0,0,0,0,1,1,0,0},
                {0,0,1,1,1,1,0,0},

        };
        X = tg;
        N = 7;
        color = new int[N + 1];
        int k = 0;
        d = new int[N + 1];
        for(int i = 1; i <=N;i++){
            if(color[i] == 0){
                System.out.print("(");
                BFS(i);
                System.out.print(")");
                k++;
            }
        }
        System.out.println();
//        System.out.println(k);
        for(int i = 1; i<=N;i++){
            System.out.print(d[i] + ",");
        }
    }

}
