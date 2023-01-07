import java.util.*;

public class MultiTestCases {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int t = io.nextInt();

        while (t-- > 0) {
            int result = 0;
            int n = io.nextInt();
            int[] test = io.nextIntArray(n);
            while (--n >= 0 ) {
                if (test[n]%2 == 1) result++;
            }

            io.output(result);
        }
        io.close();
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
