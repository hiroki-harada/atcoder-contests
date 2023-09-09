import java.util.*;

public class Measure {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        io.close();

        String result = "";
        for (int i = 0; i <= n; i++) {
            String si = "-";

            for (int j = 1; j <= 9; j++) {
                //    j がN の約数 && i がN/j の倍数
                // -> N がj の倍数 && i がN/j の倍数
                if (0 == MathUtils.mod(n, j) && 0 == MathUtils.mod(i, n/j)) {
                    si = String.valueOf(j);
                    break;
                }
            }

            result += si;
        }

        io.output(result);
    }

    private static class MathUtils {
        private static long mod(long dividend, long divisor) {
            return (Math.floorMod(dividend, divisor) + Math.abs(divisor)) % Math.abs(divisor);
        }
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private <T> void output(T result) {System.out.println(result);}
    }
}