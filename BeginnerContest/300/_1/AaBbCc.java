import java.util.*;

public class AaBbCc {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        long n = io.nextLong();
        io.close();

        final int z = 1000000; // ???
        boolean[] isPrime = new boolean[z + 1];
        int[] countPrimes = new int[z + 1];
        List<Long> primes = new ArrayList<>();

        for (int p = 2; p <= z; p++) isPrime[p] = true;
        for (int p = 2; p*p <= z; p++) {
            if (isPrime[p]) {
                for (int q = p*p; q <= z; q += p) isPrime[q] = false;
            }
        }
        for (int p = 2; p <= z; p++) {
            if (isPrime[p]) {
                primes.add((long) p);
                countPrimes[p] = 1;
            }
        }
        for (int p = 2; p <= z; p++) countPrimes[p] += countPrimes[p - 1];

        long result = 0;
        for (long a = 2; a*a*a*a*a <= n; a++) {
            if (isPrime[(int) a]) {
                for (long c = a + 1; a*a*a*c*c <= n; c++) {
                    if (isPrime[(int) c]) {
                        long br = Math.min(c - 1, n / (a*a*c*c));
                        long bl = a;
                        if (bl < br) {
                            result += countPrimes[(int) br];
                            result -= countPrimes[(int) bl];
                        }
                    }
                }
            }
        }
        io.output(result);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private long nextLong() {return this.sc.nextLong();}
        private void output(long result) {System.out.println(result);}
    }
}