import java.util.*;

public class FlipCards {
    static final long MOD = 998244353;

    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = io.nextInt();
            b[i] = io.nextInt();
        }
        io.close();

        // dp[i][j] := 0~i-1番目までのカードが条件を満たし、i番目のカードがj(=1:表、0:裏)である時に、条件を満たす場合の数
        long[][] dp = new long[n][2];

        // 初期値、裏返す場合と裏返さない場合の2パターン
        dp[0][1] = 1;
        dp[0][0] = 1;

        // 漸化式
        for (int i = 1; i < n; i++) {
            // カードi の裏表を決定するとき、カードi-1のみと相違かどうかを判定すればよい
            if (a[i] != a[i-1]) dp[i][1] += dp[i-1][1];
            if (a[i] != b[i-1]) dp[i][1] += dp[i-1][0];
            if (b[i] != a[i-1]) dp[i][0] += dp[i-1][1];
            if (b[i] != b[i-1]) dp[i][0] += dp[i-1][0];

            dp[i][0] %= MOD;
            dp[i][1] %= MOD;
        }

        io.output( (dp[n-1][0]+dp[n-1][1]) % MOD );
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private <T> void output(T result) {System.out.println(result);}
    }
}