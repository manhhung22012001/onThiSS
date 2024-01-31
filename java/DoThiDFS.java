import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DoThiDFS {
    static int N;//so dinh
    static int A[][]; //ma tran ke;
    static int color[]; //0->trang, 1-> gray, 2->black
    static int d[]; //khoang cach tu d[u] den dinh goc
    static ArrayList<ArrayList> cc;
    static void DFS(int u, ArrayList<Integer> c){
        color[u]=1;
        c.add(u);
        System.out.print(u + ",");
        for(int v = 1; v <=N; v++){
            if(A[u][v] == 1){
                if(color[v] == 0){
                    DFS(v,c);
                }
            }
        }
        color[u] = 2;
    }
    static void TopVisit(int u, Stack s){
        color[u] = 1;
        for(int v = 1; v <= u; v++){
            if(A[u][v] == 1) {
                if(color[v] == 0) {
                    TopVisit(v,s );
                }
            }
        }
        color[u] = 2;
        s.push(u);
    }
    static void DFS_Stack(int u) {
        Stack<Integer> stack = new Stack<>();
        color[u] = 1;
        stack.push(u);
        while (!stack.isEmpty()) {
            u=stack.pop();
            System.out.print(u+",");
            for(int v = 1; v<=N; v++){
                if(A[u][v] == 1){
                    if(color[v] == 0) {
                        color[v] = 1;
                        stack.push(v);
                    }
                }
            }
        }
    }
    static void BFS(int u) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(u);
        color[u] = 1;
        System.out.print(u + ",");
        cc = new ArrayList<>();
        while (!Q.isEmpty()) {
            u = Q.remove();
            for (int v = 1; v<=N; v++) {
                if(A[u][v] == 1) {
                    if(color[v] == 0) {
                        color[v] = 1;
                        System.out.print(v + ", ");
                        d[v]= 1 + d[u];
                        Q.add(v);
                    }
                }
            }
            color[u] = 2;
        }
    }
    public static void main(String[] args) {
        int t[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 1, 0, 0},
                {0, 0, 1, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 1, 0},
                {0, 0, 0, 1, 1, 0, 1},
                {0, 1, 0, 0, 0, 1, 0}

        };
        N = 6;
        A = t;
        int c[] = new int[N + 1];
        int k = 0;
        Stack<Integer> S =new Stack<>();
        color=c;
        d = new int[N + 1];
        cc = new ArrayList<>();
        for (int u = 1; u <N; u++){
            if (color[u] == 0) {
//                TopVisit(u,S);
//                ArrayList<Integer> l = new ArrayList<>();
                //DFS(u, l);
                //cc.add(l);
                BFS(u);
            }
            System.out.println();
        }
        for(int i = 1; i <=N; i++){
            System.out.print(d[i] + ",");
        }
//        while (!S.isEmpty()) {
//            System.out.print(S.pop() + ",");
//        }
//        System.out.println("\n" + cc.size());
//        for (ArrayList<Integer> l : cc){
//            System.out.println("\nThanh phan lien thong:");
//            for(Integer i : l){
//                System.out.print(i + ",");
//            }
//        }
    }
}
