import java.util.*;

public class Bitmask {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        String s = io.nextStr();
        long n = io.nextLong();
        io.close();

        // 集合Tの最小値 > n のパターン
        long min = Long.parseLong(s.replaceAll("\\?", "0"), 2);
        if (min > n) {
            io.output(-1);
            return;
        }

        // 集合Tの最大値 <= n のパターン
        long max = Long.parseLong(s.replaceAll("\\?", "1"), 2);
        if (max <= n) {
            io.output(max);
            return;
        }

        // s の上位桁から順に、? -> 1 に変えて、N を超えない値を作る
        StringBuilder sbS = new StringBuilder(s);
        for (int i = 0, len = s.length(); i < len; i++) {
            if (s.charAt(i) != '?') continue;

            // 上位桁からi番目の? を 1 に置換して、10進数に変換
            sbS.replace(i, i+1, "1");
            long dec = Long.parseLong(sbS.toString().replaceAll("\\?", "0"), 2);

            // 変換後のs がn を超えるなら、0 に戻す
            if (dec > n) sbS.replace(i, i+1, "0");
        }

        io.output(Long.parseLong(sbS.toString(), 2));
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private long nextLong() {return this.sc.nextLong();}
        private String nextStr() {return this.sc.next();}
        private void output(long result) {System.out.println(result);}
    }
}