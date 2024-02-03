import java.util.*;

public class PerfectBus {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        long[] a = in.nextLongArray(n);
        in.close();

        // 最初に0人乗っていたとして、負の人数を許容してある時点の最小人数を求める
        long min = Long.MAX_VALUE;
        long current = 0;
        for (int i = 0; i < n; i++) {
            current += a[i];
            min = Math.min(min, current);
        }

        // min < 0 の場合は、最初に m 人乗っていたとする
        long init = min < 0 ? -min : 0;
        System.out.println(init + Arrays.stream(a).sum());
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private long[] nextLongArray(int size) {
            long[] array = new long[size];
            for (int i = 0; i < size; i++) array[i] = this.sc.nextInt();
            return array;
        }
    }
}