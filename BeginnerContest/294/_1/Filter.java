import java.util.*;

public class Filter {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int[] a = io.nextIntArray(n);
        io.close();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (a[i]%2 == 0) result.append(a[i]).append(" ");
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