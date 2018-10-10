import java.util.*;

public class Main {

    public static int[] swap(int[] num, int left, int right) {
        int temp = num[left];
        num[left] = num[right];
        num[right] = temp;

        return num;
    }

    public static int sumOf(int[] a) {
        int result = 0;
        for(int i=0; i<a.length; i++) {
            result += a[i];
        }
        return result;
    }

    public static void main(String[] args) {

        //swap을 이용한 배열 내 순서교환
        int[] num = {5, 10, 73, 2, -5, 42};
        System.out.println("num 배열의 값 =>" + Arrays.toString(num));

        System.out.println("a[0]값과 a[5]값을 교환합니다...");
        System.out.println("예상 값 42 10 73 2 -5 5 =>" + Arrays.toString(Main.swap(num, 0, 5)));

        System.out.println("a[1]값과 a[4]값을 교환합니다...");
        System.out.println("예상 값 42 -5 73 2 10 5 =>" + Arrays.toString(Main.swap(num, 1, 4)));

        System.out.println("a[2]값과 a[3]값을 교환합니다...");
        System.out.println("예상 값 42 -5 2 73 10 5 =>" + Arrays.toString(Main.swap(num, 2, 3)));

        //배열의 모든 요소의 합
        System.out.println("배열의 모든 합은 ====>" + Main.sumOf(num) + "입니다...");
    }
}
