import java.util.*;

public class Coverage {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int m = io.nextInt();
        List<List<Integer>> s = new ArrayList<>();
        for (int i = 0; i < m; i++) s.add(new ArrayList<>());

        for (List<Integer> list : s) {
            int ci = io.nextInt();
            while (ci-- > 0) list.add(io.nextInt());
        }
        io.close();

        // https://qiita.com/drken/items/a5e6fe22863b7992efdb#%E5%95%8F%E9%A1%8C-4%E9%83%A8%E5%88%86%E5%92%8C%E6%95%B0%E3%81%88%E4%B8%8A%E3%81%92%E5%95%8F%E9%A1%8C

        // dp[i][j] :=  S0~Si までの集合の中からいくつかを選択して、その集合全体の連続する最大値がjとなる、場合の数
        int[][] dp = new int[m][n];

        // 初期値, S1 のみを選択した場合
        for (int i = 1; i <= n; i++) {
            if (!s.get(0).contains(i)) break;
            dp[0][i] = 1;
        }

        // 漸化式, dp[i+1][j] を求める
        for (int i = 0; i < m-1; i++) {
            for (int j = 1; j < n; j++) {
                // s.get(j) を選ぶ場合
                if (s.get(i).contains(j)) {
                    // s.get(j) に j が含まれる
                    dp[i+1][j] = dp[i][j-1];
                } else {
                    // 含まれない
                    dp[i+1][j-1] = dp[i][j-1];
                }

                // s.get(j) を選ばない場合
                dp[i+1][j] = dp[i][j];
            }
        }

        int result = 0;
        for (int[] dpi : dp) {
            result += dpi[n-1];
        }
        io.output(result);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
        private int[] nextIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) array[i] = this.sc.nextInt();
            return array;
        }
        private String[] nextStrArray(int size) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < size; i++) list.add(this.sc.next());
            return list.toArray(new String[size]);
        }
        private void output(int result) {System.out.println(result);}
        private <T> void output(T result) {System.out.println(result);}
        private void outputIntArray(int[] array, String delimiter) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < array.length; i++)  result.append(array[i]).append(delimiter);
            System.out.println(result.toString().substring(0, result.length()-delimiter.length()));
        }
        private <T> void outputArray(T[] array, String delimiter) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < array.length; i++)  result.append(array[i]).append(delimiter);
            System.out.println(result.toString().substring(0, result.length()-delimiter.length()));
        }
    }
}