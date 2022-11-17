import java.util.*;

public class HatMinusOne {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int x = io.nextInt();
        for (int i = 1; i <= n; i++) {
            int pi = io.nextInt();
            if (pi == x) {
                io.output(i);
                return;
            }
        }
        io.close();

    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private int nextInt() {return this.sc.nextInt();}

        private void output(int result) {
            System.out.println(result);
        }
    }
}