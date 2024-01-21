import java.util.*;

public class CheatingGomokuNarabe {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int h = in.nextInt();
        int w = in.nextInt();
        int k = in.nextInt();
        char[][] s = in.nextCharArray(h, w);
        in.close();

        int result = Integer.MAX_VALUE;

        // 1 行ごとに条件を満たす碁石の数を求める
        for (char[] si : s) {
            result = Math.min(result, calculateLeastInALine(si, k));
        }

        // 1 列ごとに条件を満たす碁石の数を求める
        for (int i = 0; i < w; i++) {
            char[] sj = new char[h];
            for (int j = 0; j < h; j++) sj[j] = s[j][i];

            result = Math.min(result, calculateLeastInALine(sj, k));
        }

        System.out.println(result < Integer.MAX_VALUE ? result : -1);
    }


    /*
     * array の中で、k 個の o を連続させるために . -> o に変換する場合、
     * その最小数を返す
     */
    private static int calculateLeastInALine(char[] array, int k) {
        if (array.length < k) return Integer.MAX_VALUE;

        int cntO = 0, cntX = 0;
        // array[0] ~ array[k] までの区間において、条件を満たすか判定
        for (int i = 0; i < k; i++) {
            if (array[i] == 'o') cntO++;
            if (array[i] == 'x') cntX++;
        }
        int result = (cntX == 0) ? k - cntO : Integer.MAX_VALUE;

        // array[1] ~ array[k+1] までの区間において、条件を満たすか判定
        for (int i = k; i < array.length; i++) {
            // 左端の区間を削る
            if (array[i - k] == 'o') cntO--;
            if (array[i - k] == 'x') cntX--;

            // 右端の区間を付け足す
            if (array[i] == 'o') cntO++;
            if (array[i] == 'x') cntX++;

            result = Math.min(result, (cntX == 0) ? k - cntO : Integer.MAX_VALUE);
        }

        return result;
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private char[][] nextCharArray(int size1, int size2) {
            char[][] array = new char[size1][size2];
            for (int i = 0; i < size1; i++) {
                array[i] = sc.next().toCharArray();
            }
            return array;
        }
    }
}