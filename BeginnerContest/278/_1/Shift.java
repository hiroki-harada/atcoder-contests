import java.util.*;

public class Shift {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int k = io.nextInt();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int s = io.nextInt();
            if (i >= k) result.append(s).append(" ");
        }
        io.close();
        for (int i = 0, cnt = Math.min(n, k); i < cnt; i++) result.append(0).append(" ");

        io.output(result.toString().subSequence(0, result.toString().length()-1));
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private int nextInt() {return this.sc.nextInt();}

        private <T> void output(T result) {System.out.println(result);}
    }
}