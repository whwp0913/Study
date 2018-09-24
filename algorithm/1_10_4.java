//입력받은 n단의 이등변 삼각형 출력
public class Main {

    public static void triangleRU(int n) {

        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                System.out.print(" ");
            }
            for(int k=n; k>i; k--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Main.triangleRU(10);
    }
}
