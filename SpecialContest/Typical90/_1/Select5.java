import java.util.*;

public class Select5 {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int p = io.nextInt();
        int q = io.nextInt();
        // a は事前にp で割っておく
        int[] a  = io.nextIntArray(n, p);
        io.close();

        // dp[i][j] := a の中からi+1コの整数の積をpで割ってj になる組み合わせのパターン数
        // 0 <= i < 5, 0 <= j < p
        int[][] dp = new int[5][p];

        // 初期値
        for (int i = 0; i < n; i++) dp[0][a[i]]++;

        // 漸化式
        // i = 0~i の中から4コ以下選択しているとき
        // ai+1 を選ぶ
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < p; j++) {
                dp[i+1][(j*a[i+1]) % p] += dp[i][j];
            }
        }

        // io.outputIntArray(dp[0], " ");
        // io.outputIntArray(dp[1], " ");
        // io.outputIntArray(dp[2], " ");
        // io.outputIntArray(dp[3], " ");
        // io.outputIntArray(dp[4], " ");
        io.output(dp[4][q]);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
        private int[] nextIntArray(int size, int divisor) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) array[i] = this.sc.nextInt() % divisor;
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