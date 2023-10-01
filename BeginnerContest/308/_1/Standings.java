import java.util.*;

public class Standings {
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

        long[][] cntCoinToss = new long[n][3];

        for(int i = 0; i < n; i++) {
            cntCoinToss[i][0] = i + 1;
            cntCoinToss[i][1] = a[i];
            cntCoinToss[i][2] = a[i] + b[i];
        }

        // ソートと順位の結合は個別で実行する(同時に行うと、時間がかかるため)
        Arrays.sort(cntCoinToss, (i, j) -> Long.compare(j[1]*i[2], i[1]*j[2]));

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < n; i++) result.append(cntCoinToss[i][0]).append(" ");

        io.output(result.toString().trim());
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private void output(String result) {System.out.println(result);}
    }
}