import java.util.*;

public class EvenDigits {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        long n = in.nextLong();
        in.close();

        /*
         * <方針>
         * 良い数字を 2 で割ると
         *    0, 2, 4, 6, 8, 20, 22, ...
         * -> 0, 1, 2, 3, 4, 10, 11, ...
         * のように 5 進数になる、これを 10 進数に変換すると
         * 0, 1, 2, 3, 4, 5, 6
         * となる、まとめると
         *
         * 良い数字 -- /2 --> 5進数(0始まり) -- 10進数変換 --> n-1 -- +1 --> n
         * なので、この逆の操作を行えばよい
         * n -- -1 --> 5進数変換 -- *2 --> 答え
         */

        long m = Long.parseLong(Long.toString(n-1, 5));

        System.out.println(m*2);
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private long nextLong() {return this.sc.nextLong();}
    }
}
