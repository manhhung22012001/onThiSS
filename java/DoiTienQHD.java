public class DoiTienQHD {

    static int X[];
    static int N;
    static int F[][];
    static int S;

    static void getMatrix(){
        F = new int[N+1][S+1];

        for(int i = 0; i<S+1;i++){
            F[0][i] = 999;
        }
        for(int i = 0; i< N+1;i++){
            F[i][0] = 0;
        }

        System.out.println("hiiiiiiiiiii");
        for(int i = 1; i<N+1;i++){
            for(int j = 1; j<S+1;j++){
                if(j >= X[i]){
                    if(F[i-1][j] < F[i][j-X[i]] + 1){
                        F[i][j] = F[i-1][j];
                    }else {
                        F[i][j] = F[i][j-X[i]] + 1;
                    }
                }else {
                    F[i][j] = F[i-1][j];
                }
            }
        }
    }

    static void display(){
        for(int i = 0; i < N + 1; i++){
            for (int j = 0; j < S+ 1; j++){
                System.out.print(F[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int tg[] = {99999, 1408,1,1539,1412,1029,645,1028,15,1682,1302,792,1306,166,171,1837,1845,1082,447,1857,1221,1736,202,1614,217,91,864,744,1256,498,1150};
        X = tg;
        N = 30;
        S = 6236;

        getMatrix();
        display();
        System.out.println(F[N][S]);
    }
}
