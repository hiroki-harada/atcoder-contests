import java.util.*;

public class PoisonousFullCourse {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = io.nextInt();
            y[i] = io.nextInt();
        }
        io.close();

        // dpij := i番目の料理を食べるか下げ(j, 1 = 食べる、0 = 下げる)た後、
        //        状態がk(1=お腹を壊している、0=お腹を壊していない)のとき、美味しさの総和
        long[][][] dp = new long[n+1][2][2];

        // 初期値設定は、不要

        for (int i = 1; i <= n; i++) {
            // 前回お腹を壊していて、今回食べない
            dp[i][0][1] = Math.max(dp[i-1][1][0], dp[i-1][0][1]);

            // 以下のコメントとコードを書き換える

            // おなかを壊さない/回復する
            // -> 食べる(何も起きない)、食べて回復する
            dp[i][1][0] = Math.max(y[i-1] + dp[i-1][0][0], y[i-1] + dp[i-1][0][1]);
            // 食べない(お腹を壊していない)
            dp[i][0][0] = Math.max(dp[i][1][0], dp[i-1][0][0]);
            // 食べてお腹を壊す
            dp[i][1][1] = Math.max(y[i-1] + dp[i][1][0], y[i-1] + dp[i-1][0][0]);

            System.out.println("i = " + i + ", dpi01 = " + dp[i][0][1] + ", dpi10 = " + dp[i][1][0] + ", dpi00 = " + dp[i][0][0] + ", dpi11 = " + dp[i][1][1]);
        }

        long result = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 2; k++) {
            result = Math.max(result, dp[n][j][k]);
            }
        }
        io.output(result);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private void output(long result) {System.out.println(result);}
    }
}