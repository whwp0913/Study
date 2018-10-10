import java.util.Random;

public class Main {

    public static int maxOf(int[] a) {
        int max = a[0];
        for(int i = 1; i < a.length; i++) {
            if(a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Random ran = new Random();
        Random people = new Random();

        int num = people.nextInt(50);
        int[] height = new int[num];

        for(int i =0; i < num; i++) {
            height[i] = 100 + ran.nextInt(90);
            System.out.println("height[" + i + "] :" + height[i]);
        }
        System.out.println("최댓값은" + Main.maxOf(height)+"입니다");
    }
}
