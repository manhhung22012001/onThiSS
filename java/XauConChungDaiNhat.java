public class XauConChungDaiNhat {
    static String x[];
    static String y[];
    static int N;
    static int S;
    static int F[][];

    static void getMattrix(){
        F = new int [N+1][S+1];
        for(int i = 1; i<N+1;i++){
            for(int j = 1; j<S+1;j++){
                if(x[i].equals(y[j])){
                    F[i][j] = F[i-1][j-1] + 1;
                }else {
                    if(F[i-1][j] > F[i][j-1]){
                        F[i][j] = F[i-1][j];
                    }else {
                        F[i][j] = F[i][j-1];
                    }
                }
            }
        }
    }
    static String getCommonArray(){
        String str = "";
        int i = N, j = S;
        while (i > 0 && j >0){
            if(F[i][j] == F[i-1][j]){
                i--;
            }else if(F[i][j] == F[i][j-1]){
                j--;
            }else {
                str = x[i] + str;
                i--;
                j--;
            }
        }
        return str;
    }
    public static void main(String[] args) {
        N = 11;
        S = 9;
        String str = "aBACFCHJIUII";
        String arr1[] = str.split("");

        x = arr1;
        str = "aACHJHOUMN";
        String arr2[] = str.split("");
        y = arr2;

        getMattrix();
        System.out.println(F[N][S]);
        System.out.println(getCommonArray());
     }
}
