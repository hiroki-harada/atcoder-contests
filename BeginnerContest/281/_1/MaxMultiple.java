import java.util.*;

public class MaxMultiple {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int K = io.nextInt();
        int d = io.nextInt();
        int[] a = io.nextIntArray(n);
        io.close();

        /*
         * 解答方針：DP
         * dpi,j,k : a1 ,…,ai  から j 個が選ばれていて、
         * 総和を D で割った余りが k であるようなときの総和の最大値(不可能なら −1 )
         *
         * > 答えは dpN,K,0
         */
        long[][][] dp = new long[n+1][K+1][d];
        for (long[][] ls : dp) for (long[] ls2 : ls) Arrays.fill(ls2, -1);
        dp[0][0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < K+1; j++) {
                for (int k = 0; k < d; k++) {

                    // a1 ,…,ai-1  から j 個選んだ状態から、ai+1 を選択するかどうかで場合分けを行う
                    // なお、a[0] = a1, a[1] = a2, ..., a[i] = a1+1 である

                    // 1. 上記の前提が成立しないため、スキップ
                    if (dp[i][j][k] == -1) continue;

                    // 2. ai+1 を選ばない場合の遷移
                    // ai+1 は足し合わせない
                    // i カウンタをインクリメントして、その前後の値を比較、大きい方の値で更新する
			    	dp[i+1][j][k] = Math.max(dp[i+1][j][k], dp[i][j][k]);

                    // 3. ai+1 を選ぶ場合の遷移
                    // j == K の場合、ai+1 を選択出来ないのでスキップ(j < K のループはそもそも実行されない)
                    if (j != K) {
                        // a1,…, ai, ai+1  から j+1 個選んだ場合
                        // a1,…, aiから選択した総和に ai を足して、その前後の値を比較、大きい方の値で更新する
                        dp[i+1][j+1][(k+a[i]) % d] = Math.max(dp[i+1][j+1][(k+a[i]) % d], dp[i][j][k] + a[i]);
                    }
                }
            }
        }

        io.output(dp[n][K][0]);
    }


    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private int nextInt() {return this.sc.nextInt();}

        private int[] nextIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) array[i] = this.sc.nextInt();
            return array;
        }

        private void output(long result) {System.out.println(result);}
    }
}
