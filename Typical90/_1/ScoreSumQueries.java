import java.util.*;

public class ScoreSumQueries {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int[] c = new int[n];
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = io.nextInt();
            p[i] = io.nextInt();
        }

        int[] cumulativeSum1 = new int[n+1];
        int[] cumulativeSum2 = new int[n+1];
        for (int i = 1; i <= n; i++) {
            cumulativeSum1[i] = c[i-1] == 1 ? cumulativeSum1[i-1] + p[i-1] : cumulativeSum1[i-1];
            cumulativeSum2[i] = c[i-1] == 2 ? cumulativeSum2[i-1] + p[i-1] : cumulativeSum2[i-1];
        }

        int q = io.nextInt();
        while (q-- > 0) {
            int l = io.nextInt();
            int r = io.nextInt();

            int a = cumulativeSum1[r] - cumulativeSum1[l-1];
            int b = cumulativeSum2[r] - cumulativeSum2[l-1];
            System.out.println(a + " " + b);
        }
        io.close();
    }


    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private int nextInt() {return this.sc.nextInt();}

    }
}