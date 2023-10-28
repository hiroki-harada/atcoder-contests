import java.util.*;

public class ThreeTwoSixLikeNumbers {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        in.close();

        while (true) {
            if (isMatch(n)) {
                System.out.println(n);
                return;
            }
            n++;
        }
    }

    private static boolean isMatch(int x) {
        int a = x/100;
        int b = x/10 - 10*a;
        int c = x - 100*a - 10*b;
        return a*b - c == 0 ? true : false;
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
    }
}