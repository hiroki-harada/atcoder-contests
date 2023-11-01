import java.util.*;

public class Peak {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = in.nextIntArray(n);
        in.close();

        Arrays.sort(a);

        // x = ai と仮定して、半開区間 [x,　x+M)　から条件を満たすプレゼントの個数を探す
        int result = 0;
        for (int i = 0; i < n; i++) {
            int rightIdx = Arrays.binarySearch(a, a[i]+m);

            if (rightIdx >= 0) {
                // x+m がa に存在する場合、最も小さなインデックス-1を求める
                while (rightIdx > 0 && a[rightIdx] == a[rightIdx-1]) rightIdx--;
            } else {
                // 挿入ポイントのインデックスを算出
                rightIdx = -1*rightIdx - 1;
            }
            result = Math.max(result, rightIdx - i);
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