import java.util.*;

public class ToBeSaikyo {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int[] p = io.nextIntArray(n);
        io.close();

        // n = 1
        if (n == 1) {
            io.output(0);
            return;
        }

        // n >= 2
        int p1 = p[0];
        Arrays.sort(p);
        int max = p[n-1];
        if (p1 == max && p1 != p[n-2]) io.output(0);
        else io.output(max - p1 + 1);
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