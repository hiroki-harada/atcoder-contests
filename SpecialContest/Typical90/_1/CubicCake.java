import java.util.*;

public class CubicCake {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        long a = io.nextLong();
        long b = io.nextLong();
        long c = io.nextLong();
        io.close();

        /* r x r x r の立方体を作るためには
         * a%r == b%r == c%r == 0
         * となる最大の r 、つまり a, b, c の最大公約数であれば良い
         * このとき切断回数は、各辺/r -1 の和なので、(a/r -1) + (b/r -1) + (c/r -1)
         */

        long r = gcd(gcd(a, b), c);
        io.output(a/r -1 + b/r -1 + c/r -1);
    }


    private static long mod(long dividend, long divisor) {
        return (Math.floorMod(dividend, divisor) + Math.abs(divisor)) % Math.abs(divisor);
    }

    private static long gcd(long a, long b) {
        long dividend = Math.max(a, b);
        long divisor  = Math.min(a, b);
        dividend = mod(dividend, divisor);

        if (dividend == 0) return divisor;
        return gcd(dividend, divisor);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private long nextLong() {return this.sc.nextLong();}

        private void output(long result) {
            System.out.println(result);
        }
    }
}