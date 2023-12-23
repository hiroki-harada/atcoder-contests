import java.util.*;

public class ReindeerAndSleigh {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        int q = in.nextInt();
        long[] r = in.nextLongArray(n);

        Arrays.sort(r);
        long[] cumulativeR = new long[n];
        cumulativeR[0] = r[0];
        for (int i = 0; i < n-1; i++) {
            cumulativeR[i+1] = r[i+1] + cumulativeR[i];
        }

        while (q-- > 0) {
            long x = in.nextLong();

            int idx = Arrays.binarySearch(cumulativeR, x);
            // idx = -(挿入ポイント+1) の場合
            if (idx >= 0) idx++;
            else idx = idx*(-1) - 1;

            System.out.println(idx);
        }
        in.close();
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private long nextLong() {return this.sc.nextLong();}
        private long[] nextLongArray(int size) {
            long[] array = new long[size];
            for (int i = 0; i < size; i++) array[i] = this.sc.nextLong();
            return array;
        }
    }
}