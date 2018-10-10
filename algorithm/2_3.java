import java.util.*;

public class Main {

    //배열 a의 모든 요소를 배열 b에 그대로 복사
    public static void copy(int[] a, int[] b) {
        for(int i=0; i<a.length; i++) {
            b[i] = a[i];
        }
        System.out.println("배열 a의 요소 ==>" + Arrays.toString(a));
        System.out.println("배열 b의 요소 ==>" + Arrays.toString(b));
    }

    //배열 b의 모든요소를 역순으로 배열 a에 복사
    public static void rcopy(int[] a, int[] b) {
        for(int i=b.length-1; i>=0; i--) {
            a[b.length-i-1] = b[i];
        }
        System.out.println("배열 a의 요소 ==>" + Arrays.toString(a));
        System.out.println("배열 b의 요소 ==>" + Arrays.toString(b));
    }

    public static void main(String[] args) {

        int[] a = {1,2,3,4,5};
        int[] b = new int[a.length];
        Main.copy(a,b);
        Main.rcopy(a,b);
    }
}
