import java.util.*;

public class MoneyInHand {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int x = io.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = io.nextInt();
            b[i] = io.nextInt();
        }
        io.close();

        // dp[i][j]:A1 ~ Ai 硬貨を用いて、ちょうどj円となる場合にtrue
        boolean[][] dp = new boolean[n+1][x+1];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= x; j++) {
                for (int k = 0; k <= b[i]; k++) {
                    if (j >= a[i]*k) {
                        if (dp[i][j-a[i]*k]) dp[i+1][j] = true;
                    }
                }
            }
        }
        io.output(dp[n][x] ? "Yes" : "No");
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private <T> void output(T result) {System.out.println(result);}
    }
}