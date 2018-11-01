import java.util.*;

/*
삽입정렬 > insertion Sort
1. 초기 키 값은  두 번째 자료
2. 두 번째 값과 첫 번째 값을 비교하여 정렬
3. 세 번쨰 값과 두 번째 값을 비교 후 > 첫 번째 값과 비교
4. 반복
*/
public class InsertionSortExam {

    public static void insertionSort(int[] arr) {
        //외부루프 배열의 길이-1 만큼 반복
        for(int i=0; i<arr.length-1; i++)
            //현재 key값의 인덱스 길이만큼 반복
            for(int j=i+1; j>0; j--) {
                if(arr[j] < arr[j-1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
    }

    public static void main(String[] args) {
        int[] arr = {8, 5, 6, 2, 4,100, 4, 1, 99, 300, 255};

        Main.insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
