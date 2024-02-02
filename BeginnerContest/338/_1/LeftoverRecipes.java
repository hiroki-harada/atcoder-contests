import java.util.*;

public class LeftoverRecipes {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        int[] q = in.nextIntArray(n);
        int[] a = in.nextIntArray(n);
        int[] b = in.nextIntArray(n);
        in.close();

        // 料理 A の最大料理数を求める
        int maxA = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] != 0) maxA = Math.min(maxA, q[i]/a[i]);
        }

        // 料理 A の最大料理数に応じて、A, B 合計の最大料理数を求める
        long result = 0;
        for (int cntA = 0; cntA <= maxA; cntA++) {
            // 料理 A を i 皿作ったときの残りの食材量を求める
            int[] lefts = new int[n];
            for (int i = 0; i < n; i++) lefts[i] = q[i] - a[i] * cntA;

            // 残った食材で、料理 B が何皿作れるか求める
            int cntB = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (b[i] != 0) cntB = Math.min(cntB, lefts[i]/b[i]);
            }

            // 最大料理数の判定
            result = Math.max(result, cntA+cntB);
        }

        System.out.println(result);
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
    }
}