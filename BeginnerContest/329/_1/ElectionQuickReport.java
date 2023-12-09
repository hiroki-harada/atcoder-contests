import java.util.*;

public class ElectionQuickReport {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = in.nextIntArray(m);
        in.close();

        int currentTop = a[0];
        int[] vote = new int[n+1];
        for (int ai : a) {
            // i 票目を開票
            vote[ai]++;

            // 最も得票数の多い or 投票数が同じで番号がより小さい候補者を暫定トップとする
            if (vote[ai] > vote[currentTop] || vote[ai] == vote[currentTop] && ai < currentTop)
                currentTop = ai;

            // 結果を出力する
            System.out.println(currentTop);
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
    }
}