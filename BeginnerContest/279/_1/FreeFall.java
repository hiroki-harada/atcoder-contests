import java.util.*;

public class FreeFall {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        long a = io.nextLong();
        long b = io.nextLong();
        io.close();

        long cnt = calculateLeatsCntOperates(a, b);
        cnt = cnt > 0 ? cnt : 0l;
        io.output(calculateFreeFallTime(a, b, cnt));
    }

    private static double calculateFreeFallTime(long a, long b, long cntOperates) {
        return 1.0d * (b*cntOperates + a/Math.sqrt(1.0d + cntOperates));
    }
    private static long calculateLeatsCntOperates(long a, long b) {
        return Math.round(Math.pow(2.0d*b/a, -2.0d/3.0d) - 1.0d);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private long nextLong() {return this.sc.nextLong();}

        private void output(double result) {System.out.println(result);}
    }
}
