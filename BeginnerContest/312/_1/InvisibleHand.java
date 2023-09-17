import java.util.*;

public class InvisibleHand {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int m = io.nextInt();

        int[] a = io.nextIntArray(n);
        int[] b = io.nextIntArray(m);
        io.close();

        Arrays.sort(a);
        Arrays.sort(b);

        // bi = b_max + 1 = 100,000,001 の可能性があるため
        // 1~100,000,001 の範囲で2分探査
        int right = 0, left = 1_000_000_001;
        while (right+1 < left) {
            // 探索範囲が存在する間だけ実行

            // 中間地点ギリギリの値を、a,bにおいてそれぞれ求める
            int center = (right+left)/2;
            int ai = 0, bi = 0;
            for (int i = 0; i < n; i++) if (a[i] <= center) ai++;
            for (int i = 0; i < m; i++) if (b[i] >= center) bi++;

            // 探索範囲の絞り込み(でもどうしてこれで上手くいくか分からない)
            if (ai >= bi) left = center; else right = center;
        }

        io.output(left);
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
        private void output(int result) {System.out.println(result);}
    }
}