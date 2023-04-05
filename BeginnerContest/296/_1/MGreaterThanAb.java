import java.util.*;

public class MGreaterThanAb {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        long n = io.nextLong();
        long m = io.nextLong();
        io.close();

        // a <= b とする
        // X は、1 <= a <= ⌈√M⌉ における、b = ⌈M/a⌉ を満たす値
        // 詳細は、公式解答を確認

        long x = 0l, result = Long.MAX_VALUE;
        for (long i = 1; i <= n; i++) {
            x = (m+i-1)/i;
            if (x <= n) result = Math.min(result, i*x);
            if (i > x) break;
        }

        io.output(result == Long.MAX_VALUE ? -1 : result);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private long nextLong() {return this.sc.nextLong();}
        private void output(long result) {System.out.println(result);}
    }
}