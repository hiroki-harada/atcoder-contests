import java.util.*;

public class ThreeSmoothNumbers {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        long n = in.nextLong();
        in.close();

        while (n%6 == 0) n /= 6;
        while (n%2 == 0) n /= 2;
        while (n%3 == 0) n /= 3;

        System.out.println(n == 1 ? "Yes" : "No");
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private long nextLong() {return this.sc.nextLong();}
    }
}