import java.util.*;

/*
선택정렬 > selection Sort
*/
public class SelectionSortExam {

    public static void selectionSort(int[] arr) {
	//외부루프 > 배열길이-1 만큼 반복
        for(int i=0; i<arr.length-1; i++) {
		//내부루프 > 배열길이-1,배열길이-2 ... 배열의 길이가 1이 될때까지 반복
                for(int j=i+1; j<arr.length; j++) {
                    if(arr[i] > arr[j]) {
			//인덱스 자리 스왑
                        int tmp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 6, 7, 3 ,5};

        Main.selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
