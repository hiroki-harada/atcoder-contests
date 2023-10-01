import java.util.*;

public class Potion {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int h = io.nextInt();
        int x = io.nextInt();
        int[] p = io.nextIntArray(n);
        io.close();

        int resultIdx = 0;
        for (int i = 0; i < n; i++) {
            if (h+p[i] >= x) {
                resultIdx = i+1;
                break;
            }
        }

        io.output(resultIdx);
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