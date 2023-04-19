import java.util.*;

public class YellowAndRedCard {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int q = io.nextInt();
        int[] state = new int[n];

        while (q-- > 0) {
            int op = io.nextInt();
            int x = io.nextInt()-1;

            if      (op == 1) state[x]++;
            else if (op == 2) state[x] += 2;
            else if (op == 3) io.output(state[x] >= 2 ? "Yes" : "No");
        }
        io.close();
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private <T> void output(T result) {System.out.println(result);}
    }
}