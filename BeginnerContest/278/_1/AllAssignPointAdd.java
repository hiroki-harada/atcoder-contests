import java.util.*;

public class AllAssignPointAdd {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        long[] diff = io.nextLongArray(n);
        int q = io.nextInt();

        long base = 0;
        while (q-- > 0) {
            int op = io.nextInt();
            switch (op) {
                case 1:
                    base = io.nextLong();
                    diff = new long[n];
                    break;
                case 2:
                    diff[io.nextInt()-1] += io.nextLong();
                    break;
                case 3:
                    io.output(base + diff[io.nextInt()-1]);
                    break;
            }
        }
        io.close();

    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private long nextLong() {return this.sc.nextLong();}
        private long[] nextLongArray(int size) {
            long[] array = new long[size];
            for (int i = 0; i < size; i++) array[i] = this.sc.nextInt();
            return array;
        }
        private <T> void output(T result) {System.out.println(result);}
    }
}