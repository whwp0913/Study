//입력받은 n단의 이등변 삼각형 출력
public class Main {

    public static void triangleLB(int n) {
        //세로 길이
        for(int i=0; i<=n; i++) {
            //가로 길이
            for(int j=0; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Main.triangleLB(3);
    }
}
