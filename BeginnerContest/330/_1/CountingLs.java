import java.util.*;

public class CountingLs {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        String[][] s = new String[n][n];
        for (int i = 0; i < n; i++) s[i] = in.nextStr().split("");
        in.close();

        // 任意のマスの直前上に存在する o の数を数える
        int[] row = new int[n];
        int[] col = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!s[i][j].equals("o")) continue;
                row[i]++;
                col[j]++;
            }
        }

        // 条件を満たすマスのうち、カドのマスを数える
        // o × ×
        // × × ×
        // o × o
        // ↑ カドのマス
        long result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // (i, j) のマスを除く、十字のマスから o のマスを2つ選ぶ組み合わせを集計
                if (!s[i][j].equals("o")) continue;
                result += (row[i]-1) * (col[j]-1);
            }
        }

        System.out.println(result);
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
    }
}