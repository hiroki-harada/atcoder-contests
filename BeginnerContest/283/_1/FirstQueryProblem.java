import java.util.*;

public class FirstQueryProblem {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int[] a = io.nextIntArray(n);
        int q = io.nextInt();

        for (int i = 0; i < q; i++) {
            int opType = io.nextInt();
            int k = io.nextInt()-1;

            if (opType == 1) {
                a[k] = io.nextInt();
            } else {
                io.output(a[k]);
            }
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