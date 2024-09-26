import java.util.*;

public class MinimumCoins {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        long n = io.nextLong();
        long a = io.nextLong();
        long b = io.nextLong();
        long c = io.nextLong();
        io.close();

        long result = 9999;
        for (int i = 0; i < 10_000; i++) {
            for (int j = 0; j < 10_000; j++) {

                long tmp = a*i + b*j;
                if (tmp > n || (n-tmp)%c != 0) continue;

                result = Math.min(result, i + j + (n-tmp)/c);
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