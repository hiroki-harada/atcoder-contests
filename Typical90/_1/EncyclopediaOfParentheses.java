import java.util.*;

public class EncyclopediaOfParentheses {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        io.close();

        if (n%2 == 1) return;

        // (, ) からなる2^n パターンの文字列を、"辞書順に" 生成する
        // n=4 の場合
        // "((((", "((()", "(()(", ..., ")))(", "))))"
        var allPattern = new ArrayList<String>();
        for (int bit = 0; bit < (1 << n); ++bit) { // bit = 0, 1, ..., 2^n
            StringBuilder S = new StringBuilder();

            // 最上位の桁から順に (, ) のどちらを設定するか決める
            for (int i = n - 1; i >= 0; --i) {
                if ((bit & (1 << i)) == 0) S.append("(");
                else S.append(")");
            }

            allPattern.add(S.toString());
        }

        var result = new ArrayList<String>();
        for (String pattern : allPattern) {

            boolean isClose = true;

            // 正しい括弧列のみ、答えのリストに追加
            int closeFlg = 0;
            for (String str : pattern.split("")) {
                if (str.equals("(")) closeFlg++;
                if (str.equals(")")) closeFlg--;

                if (closeFlg < 0) {
                    isClose = false;
                    break;
                }
            }
            if (closeFlg != 0) isClose = false;

            if (isClose) result.add(pattern);
        }

        io.outputList(result, "\n");
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private <T> void outputList(List<T> list, String delimiter) {
            StringBuilder result = new StringBuilder();
            for (T e : list)  result.append(e).append(delimiter);
            System.out.println(result.toString().substring(0, result.length()-delimiter.length()));
        }
    }
}