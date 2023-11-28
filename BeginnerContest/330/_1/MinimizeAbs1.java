import java.util.*;

public class MinimizeAbs1 {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        int l = in.nextInt();
        int r = in.nextInt();
        int[] a = in.nextIntArray(n);
        in.close();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // 丁寧に場合分けすると、下記の結果が得られる
            // ai < l     -> xi = l
            // l < ai < r -> xi = ai
            // ai > r     -> xi = r
            result
            .append(Math.max(Math.min(a[i], r), l))
            .append(" ");
        }

        System.out.println(result.toString().trim());
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