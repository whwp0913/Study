/*
1부터 n까지의 합
*/
public class Main {

    public static int sum(int endNum) {
        if (endNum < 0 ) {
            System.out.println("정수를 입력해주세요...");
            return 0;

        }
        int result = 0;
        for(int i=0; i <= endNum; i++) {
            result += i;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("0부터 ~ N까지의 합 :" + Main.sum(100) + "입니다");
    }
}
