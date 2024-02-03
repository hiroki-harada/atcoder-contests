import java.util.*;

// _2
public class CheatingGomokuNarabe {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int h = in.nextInt();
        int w = in.nextInt();
        int k = in.nextInt();
        String[] s = in.nextStrArray(h);
        in.close();

        int result = Integer.MAX_VALUE;

        // 横方向のマスをチェックする
        for (String si : s) {
            result = Math.min(result ,countMinOperations(si.toCharArray(), k));
        }

        // 縦方向のマスをチェックする
        for (int i = 0; i < w; i++) {
            char[] t = new char[h];
            for (int j = 0; j < h; j++) t[j] = s[j].charAt(i);

            result = Math.min(result ,countMinOperations(t, k));
        }

        System.out.println(result < Integer.MAX_VALUE ? result : -1);
    }

    /*
     * array の中で、k 個の o を連続させるために . -> o に変換する場合、
     * その最小数を返す
     */
    private static int countMinOperations(char[] line, int k) {
        if (line.length < k) return Integer.MAX_VALUE;

        int cntO = 0, cntX = 0;
        // array[0] ~ array[k-1] までの区間において、
        // . -> o に何回変換すれば、o が k 個連続した列を作成出来るかカウント
        for (int i = 0; i < k; i++) {
            if (line[i] == 'o') cntO++;
            if (line[i] == 'x') cntX++;
        }
        int result = cntX == 0 ? k - cntO : Integer.MAX_VALUE;

        // array[i] ~ array[k-1+i] (1<=i)までの区間において、同様の操作を行う
        for (int i = 0; i < line.length - k; i++) {
            // 左端の区間を削る
            if (line[i] == 'o') cntO--;
            if (line[i] == 'x') cntX--;

            // 右端の区間を付け足す
            if (line[k + i] == 'o') cntO++;
            if (line[k + i] == 'x') cntX++;

            result = Math.min(result, cntX == 0 ? k - cntO : Integer.MAX_VALUE);
        }

        return result;
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String[] nextStrArray(int size) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < size; i++) list.add(this.sc.next());
            return list.toArray(new String[size]);
        }
    }
}