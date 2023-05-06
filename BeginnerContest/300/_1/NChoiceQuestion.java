import java.util.*;

public class NChoiceQuestion {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int a = io.nextInt();
        int b = io.nextInt();
        int[] c = io.nextIntArray(n);
        io.close();

        int result = a+b;
        for (int i = 0; i < n; i++) {
            if (c[i] == result) {
                io.output(i+1);
                return;
            }
        }
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