import java.util.*;

public class TrickTaking {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int t = io.nextInt();
        int[] c = io.nextIntArray(n);
        int[] r = io.nextIntArray(n);
        io.close();

        int result = -1;
        int maxR = 0;
        for (int i = 0; i < n; i++) {
            if (c[i] == t && r[i] > maxR) {
                maxR = r[i];
                result = i+1;
            }
        }
        if (result != -1) {
            io.output(result);
            return;
        }

        result = 1;
        maxR = r[0];
        for (int i = 0; i < n; i++) {
            if (c[i] == c[0] && r[i] > maxR) {
                maxR = r[i];
                result = i+1;
            }
        }
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