import java.util.*;

public class FactorialAndMultiple {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        long k = io.nextLong();
        io.close();

        /*
         * [実装方針]
         * 任意の自然数a, b に対して、
         * a * b = gcd(a, b) * lcm(a, b) -> lcm(a, b) = a*b / gcd(a, b) が成立する
         *
         * a = K, b = N! とすると、lcm(K, N!) = K*N! / gcd(K, N!)
         * ここで、N! = N * (N-1)! = gcd(N, (N-1)!) * lcm(N, (N-1)!) である事に注目すると
         * 保留
         */
        for (int i = 2; i < 2e6; i++) {
            k /= gcd(k, i);
            if (k == 1) {
                System.out.println(i);
                return;
            }
        }
        io.output(k);
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

        private void output(long result) {System.out.println(result);}
    }
}