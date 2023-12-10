import java.util.*;

public class AHatA {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        long b = in.nextLong();
        in.close();

        final int MAX_DIGITS = 15;

        for (int i = 1; i <= MAX_DIGITS; i++) {
            if (pow(i, i) == b) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }

    /*
     * base ^ exp を返す
     * ※Math.pow() は大きな値を精度良く計算できないため、自作
     */
    private static long pow(long base, long exp) {
        long result = 1;
        for (int i = 0; i < exp; i++) result *= base;
        return result;
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private long nextLong() {return this.sc.nextLong();}
    }
}