import java.util.*;

public class ThreeFourThree {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        long n = in.nextLong();
        in.close();

        // 立方数について、全探索して条件を満たすか判定
        long result = 0;
        for (long i = (long)Math.cbrt(n); i > 0; i--) {
            long cube = i*i*i;
            if (isPalindrome(cube)) {
                result = cube;
                break;
            }
        }

        System.out.println(result);
    }

    /*
     * 文字列に変換して、文字列が回文かどうかをチェックする
     */
    private static boolean isPalindrome(long cube) {
        String str = Long.toString(cube);
        StringBuilder reversed = new StringBuilder(str).reverse();
        return str.equals(reversed.toString());
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private long nextLong() {return this.sc.nextLong();}
    }
}