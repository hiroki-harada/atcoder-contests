import java.util.*;

public class MinimizeAbs2 {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        long d = in.nextLong();
        in.close();

        long result = Long.MAX_VALUE;
        for (long xi = 0; xi*xi <= d; xi++) {
            // x^2 + y^2 = d のような円の方程式と解釈する
            // xi = 0 ~ √d の近傍、までの値で |xi^2 + yi^2 -d | の最小値を全探索する
            long yi = (long)Math.sqrt(d - xi*xi);

            // yi切り捨ての場合
            result = Math.min(result, (long)Math.abs(xi*xi + yi*yi - d));
            // yi切り上げの場合
            yi++;
            result = Math.min(result, (long)Math.abs(xi*xi + yi*yi - d));
        }

        System.out.println(result);
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private long nextLong() {return this.sc.nextLong();}
    }
}