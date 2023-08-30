import java.util.*;

public class MissingNo {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int[] a = io.nextIntArray(n);
        io.close();

        Arrays.sort(a);
        int sumA = Arrays.stream(a).sum();
        int fixedSumA = (a[0]+a[n-1])*(n+1) / 2;
        io.output(fixedSumA - sumA);
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