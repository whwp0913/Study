public class Main {

    //세 개의 수를 입력받아서 중앙 값을 뽑는 함수
    public static int mid(int a, int b, int c) {
        if(a >= b) {
            if(b >= c) {
                return b; //c <= b <= a
            } else if(a <= c) {
                return a; //b <= a <= c
            } else {
                return c; // b <= c <= a
            }
        } else if(a > c) {
            return a; //c < a < b
        } else if(b > c) {
            return c; // a < c <b
        } else {
            return b; // a < b < c
        }
    }

    public static void main(String[] args) {
        System.out.println(Main.mid(1,2,3));
    }
}

