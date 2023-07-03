import java.util.*;

public class ShiftVsCapsLock {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        long x = io.nextLong();
        long y = io.nextLong();
        long z = io.nextLong();
        String s = io.nextStr();
        io.close();

        // dp[i][j] := i 文字目の入力後、CapsLock が j (=0:OFF, 1:ON) だった場合の最短累計秒数
        long[][] dp = new long[s.length()+1][2];

        // 初期値設定
        dp[0][0] = 0;
        dp[0][1] = z;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                // 操作後に、CapsLock OFF になる場合
                // そのまま入力 or CapsLock ONにして入力
                dp[i+1][0] = Math.min(dp[i][0] + x, dp[i][1] + x + z);
                // 操作後に、CapsLock ON になる場合
                // shift同時押し or CapsLock ONにしてshift同時押し
                dp[i+1][1] = Math.min(dp[i][1] + y, dp[i][0] + y + z);
            } else {
                // 操作後に、CapsLock OFF になる場合
                // shift同時押し or CapsLock OFFにしてshift同時押し
                dp[i+1][0] = Math.min(dp[i][0] + y, dp[i][1] + y + z);
                // 操作後に、CapsLock ON になる場合
                // そのまま入力 or CapsLock OFFにして入力
                dp[i+1][1] = Math.min(dp[i][1] + x, dp[i][0] + x + z);
            }
        }

        io.output(Math.min(dp[s.length()][0], dp[s.length()][1]));
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private long nextLong() {return this.sc.nextLong();}
        private String nextStr() {return this.sc.next();}
        private void output(long result) {System.out.println(result);}
    }
}