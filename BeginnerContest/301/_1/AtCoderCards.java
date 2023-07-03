import java.util.*;

public class AtCoderCards {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        String s = io.nextStr();
        String t = io.nextStr();
        io.close();

        final String ATCODER = "atcoder";
        final String REPLACE = "bfghijklmnpqsuvwxyz";

        int cntAtMarksInS = countCharInStr("@", s);
        int cntAtMarksInT = countCharInStr("@", t);
        for (String str : ATCODER.split("")) {
            // s/t から a,t,c,o,d,e,r の各文字を削った個数を、それぞれ求める
            int sCnt = countCharInStr(str, s);
            int tCnt = countCharInStr(str, t);

            // 削った個数を比較し、その差分だけ、@を減らす
            if (sCnt > tCnt) cntAtMarksInT -= sCnt - tCnt;
            if (tCnt > sCnt) cntAtMarksInS -= tCnt - sCnt;

            // s/t どちらかの @ の個数が不足したら、No
            if (cntAtMarksInS >= 0 && cntAtMarksInT >= 0) continue;

            io.output("No");
            return;
        }

        // s/t からa,t,c,o,d,e,r の各文字を削る
        s = remove(s, ATCODER);
        t = remove(t, ATCODER);

        // a,t,c,o,d,e,r 以外の文字は、個数が一致しなかった時点でNo
        for (String str : REPLACE.split("")) {
            int sCnt = countCharInStr(str, s);
            int tCnt = countCharInStr(str, t);
            if (sCnt == tCnt) continue;

            io.output("No");
            return;
        }
        io.output("Yes");
    }

    private static int countCharInStr(String ch, String str) {
        return str.length() - str.replace(ch, "").length();
    }

    private static String remove(String target, String replace) {
        for (String str : replace.split("")) {
            target = target.replace(str, "");
        }
        return target;
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private String nextStr() {return this.sc.next();}
        private <T> void output(T result) {System.out.println(result);}
    }
}