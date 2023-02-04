import java.util.*;

public class FreeFall {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        long a = io.nextLong();
        long b = io.nextLong();
        io.close();

        double cnt = calculateLeatsCntOperates(a, b);
        // cnt 近傍の2整数のうち、落下時間が小さくなる方を出力
        io.output(Math.min(
            calculateFreeFallTime(a, b, Math.ceil(cnt)),
            calculateFreeFallTime(a, b, Math.floor(cnt))
        ));
    }

    private static double calculateFreeFallTime(long a, long b, double cntOperates) {
        return 1d*b*cntOperates + 1d*a/Math.sqrt(1d + cntOperates);
    }
    private static double calculateLeatsCntOperates(long a, long b) {
        return Math.pow(2d*b/(1d*a), -2d/3d) - 1d;
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private long nextLong() {return this.sc.nextLong();}

        private void output(double result) {System.out.println(result);}
    }
}
