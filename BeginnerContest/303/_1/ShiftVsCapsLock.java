import java.util.*;

public class ShiftVsCapsLock {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int x = io.nextInt();
        int y = io.nextInt();
        int z = io.nextInt();
        String s = io.nextStr();
        io.close();

        // dp[i][j] := i 文字目を入力した時、CapsLock が j (=0:OFF, 1:ON) だった場合の最短累計秒数
        int[][] dp = new int[s.length()+1][2];
        // 初期値設定は省略

        for (int i = 0; i < s.length(); i++) {
            // cur := 1:A, 0:a; 2値に置き換える
            int cur = s.charAt(i) == 'a' ? 0 : 1;

            for (int j = 0; j < 2; j++) {
                // clFlag := CapsLock =0:OFF, 1:ON)
                for (int clFlag = 0; clFlag < 2; clFlag++) {
                    int time = dp[i][j];

                    // capsLock を押下した場合
                    if (j != clFlag) time += z;
                    // shift同時押しした場合
                    time += cur == clFlag ? x : y;

                    dp[i+1][clFlag] = Math.min(time, dp[i+1][clFlag]);
                }
            }

            io.output("i, dp[i+1][0], dp[i+1][0] = " + (i+1) + ", " + dp[i+1][0] + ", " + dp[i+1][1]);
        }

        io.output(Math.min(dp[s.length()][0], dp[s.length()][1]));
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
        private void output(int result) {System.out.println(result);}
        private <T> void output(T result) {System.out.println(result);}
    }
}