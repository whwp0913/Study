/*
입력 받은 값 자릿수 출력
1-9 => 1자리수
10-99 => 2자리수
100-999 => 3자리수 입니다...
*/
public class Main {

    public static void checkNum(int a) {
        if(a < 0) {
            System.out.println("양수를 입력해주세요....");
            return;
        }

        int checkNum = a;
        int result = 0;
        int i=0;

        do {
            checkNum /= 10;
            i++;
            result = i;
        } while(checkNum > 0);
        System.out.printf("입력하신 값 %d는 %d자리 수 입니다%n", a,result);
    }

    public static void main(String[] args) {
        Main.checkNum(999);
    }
}

