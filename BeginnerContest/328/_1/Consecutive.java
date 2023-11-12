import java.util.*;

public class Consecutive {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        int q = in.nextInt();
        String s = in.nextStr();
        int[] l = new int[q];
        int[] r = new int[q];
        for (int i = 0; i < q; i++) {
            l[i] = in.nextInt()-1;
            r[i] = in.nextInt()-1;
        }
        in.close();

        // 事前に累積和を求める
        // cumulativeSum[i] := 1文字目からi文字目までの間に、 同じ英小文字が 2 つ隣りあう数
        int[] cumulativeSum = new int[n];
        cumulativeSum[0] = 0;
        for (int i = 1; i < n; i++) {
            cumulativeSum[i] = cumulativeSum[i-1];
            if (s.charAt(i-1) == s.charAt(i)) cumulativeSum[i]++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            result.add(cumulativeSum[r[i]] - cumulativeSum[l[i]]);
        }

        result.stream().forEach(System.out::println);
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
    }
}