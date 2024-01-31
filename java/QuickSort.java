import java.util.Scanner;

public class QuickSort {
    public static void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if(index - 1 > left){
            quickSort(arr,left,index-1);
        }
        if(index < right) {
            quickSort(arr, index, right);;
        }
    }
    public static int partition(int arr[], int left, int right){
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right)/2];
        while (i <= j) {
            while (arr[i] < pivot){
                i++;
            }
            while (arr[j] > pivot ){
                j--;
            }
            if(i<=j){
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strArr[];

        strArr = scanner.nextLine().split(" ");
        int arr[] = new int[strArr.length];
        for(int i = 0; i<strArr.length;i++){
            arr[i]=Integer.valueOf(strArr[i]);
        }
        quickSort(arr,0,arr.length-1);
        for (int i =0;i<arr.length;i++){
            System.out.print(arr[i] + " ");

        }
    }
}
