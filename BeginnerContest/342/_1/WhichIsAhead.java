import java.util.*;

public class WhichIsAhead {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        int[] p = in.nextIntArray(n);
        int q = in.nextInt();
        int[] a = new int[q];
        int[] b = new int[q];
        for (int i = 0; i < q; i++) {
            a[i] = in.nextInt();
            b[i] = in.nextInt();
        }
        in.close();

        // 配列を走査して地道に探す
        for (int i = 0; i < q; i++) {
            int idxA = find(a[i], p);
            int idxB = find(b[i], p);
            System.out.println(idxA < idxB ? a[i] : b[i]);
        }
    }


    private static int find(int key, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (key == array[i]) {
                return i;
            }
        }
        return -1;
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