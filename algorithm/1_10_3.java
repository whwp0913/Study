public class Main {

    public static void triangleRB(int n) {

        for(int i=n; i>0; i--) {
            for(int j=0; j<i-1; j++) {
                System.out.print(" ");
            }
            for(int k=n; k>=i; k--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Main.triangleRB(10);
    }
}
