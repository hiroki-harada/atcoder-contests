import java.util.*;

public class Discord {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int m = io.nextInt();
        int[][] a = io.nextIntArray(m, n);
        io.close();

        // isFriendly[i-1][j-1] = true := i, j は仲良し
        boolean[][] isFriendly = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n-1; j++) {

                // 隣接する2人にチェック(入れ替えも考慮)
                isFriendly[a[i][j  ]-1][a[i][j+1]-1] = true;
                isFriendly[a[i][j+1]-1][a[i][j  ]-1] = true;
            }
        }

        int result = 0;
        // 上三角成分だけ集計
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (!isFriendly[i][j]) result++;
            }
        }
        io.output(result);
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
        private int[][] nextIntArray(int size1, int size2) {
           int[][] array = new int[size1][size2];
           for (int i = 0; i < size1; i++) array[i] = nextIntArray(size2);
           return array;
        }
        private void output(int result) {System.out.println(result);}
    }
}