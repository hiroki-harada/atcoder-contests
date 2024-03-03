import java.util.*;

public class AdjacencyMatrix {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        int[][] a = in.nextIntArray(n, n);
        in.close();

        for (int i = 0; i < n; i++) {
            // 頂点 i と頂点 j を結ぶ辺 を順次追加し、最後に出力する
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) sb.append(j + 1).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    private static class InputHandler {
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
    }
}