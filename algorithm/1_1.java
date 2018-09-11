public class Main {

    // 네 값의 최대값
    public static int max(int a, int b, int c, int d) {
        int result = a;

        if(result < b) { result = b; }
        if(result < c) { result = c; }
        if(result < d) { result = d; }

        return result;
    }
    // 세 값의 최소값
    public static int min(int a, int b, int c) {
        int result = a;

        if(result > b) { result = b; }
        if(result > c) { result = c; }

        return result;
    }
    // 네 값의 최소값
    public static int min(int a, int b, int c, int d) {
        int result = a;
        if(result > b) { result = b; }
        if(result > c) { result = c; }
        if(result > d) { result = d; }

        return result;
    }


    public static void main(String[] args) {
        System.out.println("max(1,2,3,4) :"+Main.max(1,2,3,4));
        System.out.println("min(1,2,3) :"+Main.min(1,2,3));
        System.out.println("min(1,2,3,4) :"+Main.min(1,2,3,4));
    }
}

