import java.util.*;

public class SelectOne {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int k = io.nextInt();
        int[] a = io.nextIntArray(n);
        int[] b = io.nextIntArray(n);
        io.close();

        // Ai, Bi の差分の和を取る
        // 以下のような場合に、sum = 0 と判定されるため、絶対値を取ってから加算する
        // A = {1, 4, 4}, B = {2, 3, 4}
        int sum = 0;
        while (n-- > 0) sum += Math.abs(a[n] - b[n]);

        if (sum == k) io.output("Yes");
        if (sum > k) io.output("No");
        if (sum < k) io.output((k-sum)%2 == 0 ? "Yes" : "No");
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

        private <T> void output(T result) {
            System.out.println(result);
        }
    }
}