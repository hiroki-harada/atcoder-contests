import java.util.*;

public class RangeSwap {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int p = io.nextInt()-1;
        int q = io.nextInt()-1;
        int r = io.nextInt()-1;
        io.nextInt(); // discard s
        int[] a = io.nextIntArray(n);
        io.close();

        for (int i = 0; i < q-p+1; i++) {
            int tmp = a[r+i];
            a[r+i] = a[p+i];
            a[p+i] = tmp;
        }
        io.outputIntArray(a, " ");
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
        private void outputIntArray(int[] array, String delimiter) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < array.length; i++)  result.append(array[i]).append(delimiter);
            System.out.println(result.toString().substring(0, result.length()-delimiter.length()));
        }
    }
}