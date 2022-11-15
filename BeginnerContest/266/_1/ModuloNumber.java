import java.util.*;

public class ModuloNumber {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        long n = io.nextLong();
        io.close();

        io.output(mod(n, 998244353));
    }


    private static long mod(long dividend, long divisor) {
        return (Math.floorMod(dividend, divisor) + Math.abs(divisor)) % Math.abs(divisor);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private long nextLong() {return this.sc.nextLong();}

        private void output(long result) {System.out.println(result);}
    }
}
