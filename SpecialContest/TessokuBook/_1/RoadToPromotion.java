import java.util.*;

public class RoadToPromotion {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n+1; i++) graph.add(new ArrayList<>());
        for (int i = 2; i <= n; i++) {
            int a = io.nextInt();
            // 上司a -> 部下i の方向に線を追加
            graph.get(a).add(i);
        }
        io.close();

        // dp[i] := 社員i の部下の数
        int[] dp = new int[n+1];

        // 初期値 0(int のデフォルト値)
        // 漸化式
        for (int i = n; i > 0; i--) {
            // 社員i の任意の部下をai とする
            // 社員i の部下の数 = Σ(社員aiの部下の数 + 社員ai)
            // > dp[i]= Σ(dp[ai] + 1)
            for (int ai : graph.get(i)) dp[i] += dp[ai] + 1;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i < n; i++) {
            result.append(dp[i]).append(" ");
        }
        result.append(dp[n]);

        io.output(result.toString());
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private <T> void output(T result) {System.out.println(result);}
    }
}