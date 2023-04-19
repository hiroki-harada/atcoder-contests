import java.util.*;

public class ASCIIArt {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int h = io.nextInt();
        int w = io.nextInt();
        int[][] a = new int[h][w];
        for (int i = 0; i < h; i++) a[i] = io.nextIntArray(w);
        io.close();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                result.append(
                    // 1 -> A, 2 -> B, .. に変換
                    a[i][j] == 0 ? "." : Character.toString(a[i][j] + 64)
                );
            }
            result.append("\n");
        }
        io.output(result.toString());
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
        private <T> void output(T result) {System.out.println(result);}
    }
}