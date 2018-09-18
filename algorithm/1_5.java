/*
a와 b사이의 정수들의 합을 구하는 메서드를 작성하세요
static int sumof(int a, int b)
*/
public class Main {

    public static int sumof(int a, int b) {
        int result = 0;
        int start = 0;
        int endNum = 0;

        if ( a >= b) {
            start = b;
            endNum = a;
        } else {
            start = a;
            endNum = b;
        }

        for(int i = start; i <= endNum; i++) {
            result += i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Main.sumof(-10,1));
    }
}

