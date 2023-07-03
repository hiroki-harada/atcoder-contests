import java.util.*;

public class FirstPlayer {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        String[] s = new String[n];
        long[] a = new long[n];

        int indexOfMinAge = -1;
        long minOfAge = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            s[i] = io.nextStr();
            a[i] = io.nextLong();
            // 最少年齢のindexを保持
            if (a[i] < minOfAge) {
                indexOfMinAge = i;
                minOfAge = a[i];
            }
        }
        io.close();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {

            // 人nの次は人1に戻るよう調整
            int idx = indexOfMinAge + i;
            if (idx >= n) idx -= n;

            result.append(s[idx]);
            if (i != n-1) result.append("\n");
        }
        io.output(result.toString());
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private long nextLong() {return this.sc.nextLong();}
        private String nextStr() {return this.sc.next();}
        private <T> void output(T result) {System.out.println(result);}
    }
}