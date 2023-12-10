import java.util.*;

public class Next {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);
        in.close();

        Arrays.sort(a);
        int max = a[n-1];

        int result = 0;
        for (int ai : a) {
            if (ai == max) continue;
            result = Math.max(result, ai);
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