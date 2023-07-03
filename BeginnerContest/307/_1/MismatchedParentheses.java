import java.util.*;

public class MismatchedParentheses {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        var s = io.nextStr().toCharArray();
        io.close();

        var indexStore = 0;
        var result = new StringBuilder();
        var p = new int[n];
        for (int i = 0, len = s.length; i < len; i++) {
            if (s[i] == '(') {
                p[indexStore] = result.length();
                indexStore++;
                result.append(s[i]);
            }
            else  if (s[i] == ')') {
                if (indexStore == 0) {
                    // 括弧が閉じていない場合
                    result.append(s[i]);
                } else {
                    // 括弧が閉じている場合
                    indexStore--;

                    // last 番目以降の文字を削除
                    result.delete(p[indexStore], result.length());
                }

            }
            else {
                result.append(s[i]);
            }
        }
        io.output(result.toString());
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
        private <T> void output(T result) {System.out.println(result);}
    }
}