import java.util.*;

public class RotateAndPalindrome {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        long a = io.nextLong();
        long b = io.nextLong();
        String s = io.nextStr();
        io.close();

        // a 円払う操作を、見かけ上実施したとみなすためのテコ入れ
        s += s;
        long leastPaidMoney = Long.MAX_VALUE;
        // a 円払う操作はn 回未満(n 回実行すると元の文字列に戻るため)
        for (int i = 0; i < n; i++) {
            // S の左端の文字をiコ 右端に移動
            // >S の左端iの文字目からn文字を判定に使用する
            long tmp = a * i;
            for (int j = 0; j < n/2; j++) {
                int left  = i + j;         // 左から i+j 文字目
                int right = i + n - 1 - j; // 右から i+j 文字目
                if (s.charAt(left) != s.charAt(right)) tmp += b;
            }
            leastPaidMoney = Math.min(leastPaidMoney, tmp);
        }
        io.output(leastPaidMoney);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private long nextLong() {return this.sc.nextLong();}
        private String nextStr() {return this.sc.next();}
        private void output(long result) {System.out.println(result);}
    }
}