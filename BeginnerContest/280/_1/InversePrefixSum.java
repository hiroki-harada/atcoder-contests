import java.util.*;

public class InversePrefixSum {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        long[] a = new long[n];
        long ak = 0;
        for (int i = 0; i < n; i++) {
            a[i] = io.nextLong() - ak;
            ak += a[i];
        }
        io.close();

        StringBuilder result = new StringBuilder();
        for (long ai : a) result.append(ai).append(" ");
        io.output(result.toString().subSequence(0, result.length()-1));
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private int nextInt() {return this.sc.nextInt();}

        private long nextLong() {return this.sc.nextLong();}

        private <T> void output(T result) {System.out.println(result);}
    }
}