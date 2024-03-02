import java.util.*;

public class DiversityOfScores {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        int t = in.nextInt();
        int[] a = new int[t];
        int[] b = new int[t];
        for (int i = 0; i < t; i++) {
            a[i] = in.nextInt() - 1;
            b[i] = in.nextInt();
        }
        in.close();

        long[] scores = new long[n];
        Map<Long, Long> scoresDistribution = new HashMap<>();
        scoresDistribution.put(0l, (long)n);
        int kindOfscore = 1;
        for (int i = 0; i < t; i++) {
            // 得点前において、a[i] と同じ点数を持つ人がいない場合
            long oldCntPlayer = scoresDistribution.getOrDefault(scores[a[i]], 1l);
            if (oldCntPlayer == 1) kindOfscore--;
            scoresDistribution.put(scores[a[i]], --oldCntPlayer);

            // 得点を更新
            scores[a[i]] += b[i];

            // 得点後において、a[i] と同じ点数を持つ人がいない場合
            long newCntPlayer = scoresDistribution.getOrDefault(scores[a[i]], 0l);
            if (newCntPlayer == 0l) kindOfscore++;
            scoresDistribution.put(scores[a[i]], ++newCntPlayer);

            // 得点種を出力
            System.out.println(kindOfscore);
        }
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
    }
}