import java.util.*;

public class FourVariables {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        io.close();

        /*
         * <実装方針>
         * X + Y = N として、X = AB を満たすA, B の数cntX Y = CD を満たすC, D の数cntYをそれぞれ求める
         * A ≦ B とすると、0 ≦ A ≦ √X の範囲を探せばよい
         */
        long result = 0;
        for (int ab = 1; ab < n; ab++) {
            int cd = n - ab;
            long cntX = 0, cntY = 0;

            for (int i = 1; i*i <= ab; i++) {
                if (ab%i == 0) {
                    cntX++;
                    // A < B の場合、A, B を入れ替えたパターンも勘定する
                    if (i*i != ab) cntX++;
                }
            }
            for (int i = 1; i*i <= cd; i++) {
                if (cd%i == 0) {
                    cntY++;
                    // C < D の場合、C, Dを入れ替えたパターンも勘定する
                    if (i*i != cd) cntY++;
                }
            }

            result += cntX * cntY;
        }

        io.output(result);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private void output(long result) {System.out.println(result);}
    }
}