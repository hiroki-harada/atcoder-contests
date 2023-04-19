import java.util.*;

public class DoubleClick {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int d = io.nextInt();
        int[] t = io.nextIntArray(n);
        io.close();

        for (int i = 0; i < n-1; i++) {
            if (t[i+1]-t[i] <= d) {
                io.output(t[i+1]);
                return;
            }
        }
        io.output(-1);
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