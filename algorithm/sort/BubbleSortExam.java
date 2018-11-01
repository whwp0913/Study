import java.util.*;

/*
버블정렬 > bubble Sort
*/
public class BubbleSortExam {

    public static void bubbleSort(int[] arr) {
        for(int i=0; i<arr.length-1; i++) {
            for(int j=0; j<arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 4, 5, 1, 3};

        Main.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
