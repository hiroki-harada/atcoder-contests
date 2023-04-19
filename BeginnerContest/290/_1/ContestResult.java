import java.util.*;

public class ContestResult {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int m = io.nextInt();
        int[] a = io.nextIntArray(n);
        int[] b = io.nextIntArray(m);
        io.close();

        int result = 0;
        for (int i : b) result += a[i-1];
        io.output(result);
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