import java.util.*;

public class Select5 {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        long p = io.nextLong();
        long q = io.nextLong();
        // a は事前にp で割っておく
        long[] a  = io.nextlongArray(n, p);
        io.close();

        // 全探索
        // nC5 ~ 1/120 * N^5
        // 定数倍が 1/120 と小さいため O(N^5) でもTLE しない(5 sec. だけど)
        long result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < j; k++) {
                    for (int l = 0; l < k; l++) {
                        for (int m = 0; m < l; m++) {
                            if (a[i]*a[j]%p * a[k]%p * a[l]%p * a[m]%p == q) result++;
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
        private int nextInt() {return this.sc.nextInt();}
        private long nextLong() {return this.sc.nextLong();}
        private long[] nextlongArray(int size, long divisor) {
            long[] array = new long[size];
            for (int i = 0; i < size; i++) array[i] = this.sc.nextLong() % divisor;
            return array;
        }
        private void output(long result) {System.out.println(result);}
    }
}