import java.util.*;

public class ChristmasTrees {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        long a = in.nextLong();
        long m = in.nextLong();
        long l = in.nextLong();
        long r = in.nextLong();
        in.close();

        // 左端・右端の木の位置を求める(余りが負になる可能性の考慮が必要)
        long leftTree = l + MathUtils.mod(a-l, m);
        long rightTree = r - MathUtils.mod(r-a, m);

        System.out.println((rightTree-leftTree)/m + 1);
    }

    private static class MathUtils {
        private static long mod(long dividend, long divisor) {
            return (Math.floorMod(dividend, divisor) + Math.abs(divisor)) % Math.abs(divisor);
        }
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private long nextLong() {return this.sc.nextLong();}
    }
}