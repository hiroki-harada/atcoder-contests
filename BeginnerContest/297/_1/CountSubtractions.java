import java.util.*;

public class CountSubtractions {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        long a = io.nextLong();
        long b = io.nextLong();
        io.close();


        // 以下、a,b は可換として考える
        long result = 0l;
        while (true) {
            if (b == a) {
                io.output(result);
                return;
            } else if (Math.max(a, b)%Math.min(a, b) == 0) {
                // a が b の倍数
                io.output(result + Math.max(a, b)/Math.min(a, b) - 1);
                return;
            }

            // b > a のとき、a >= b となるまでの計算回数を求める
            if (b-a > 0) {
                result += b/a;
                b %= a;
            } else {
                result += a/b;
                a %= b;
            }
        }
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private long nextLong() {return this.sc.nextLong();}
        private void output(long result) {System.out.println(result);}
    }
}