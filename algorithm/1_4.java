/*
가우스 덧셈을 이용한 1부터 n까지의 합
짝수일때 (1+n) * (n/2)
홀수일떄 (1+n) * (n/2) + ((n/2)+1)
*/
public class Main {

    public static int sum(int endNum) {
        if(endNum < 0) {
            System.out.println("양수를 입력해주세요...");
            return 0;
        }

        int result = 0;

        if (endNum%2 != 0) {
            result = (1+endNum) * (endNum/2) + (endNum/2+1);
        } else {
            result = (1+endNum) * (endNum/2);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("가우스덧셈을 이용한 N까지의 합 -> Main.sum(10) :" + Main.sum(9) + "입니다");
    }
}

