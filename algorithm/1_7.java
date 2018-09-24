//구구단
public class Main {

    public static void gugudan() {
        System.out.printf("\t");
        for(int z=1; z < 10; z++) {
            System.out.printf("%3d", z);
        }
        System.out.println();
        for(int i=1; i < 10; i++) {
                System.out.printf("%2d |", i);
            for(int j=1; j < 10; j++) {
                System.out.printf("%3d", i*j);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Main.gugudan();
    }
}
