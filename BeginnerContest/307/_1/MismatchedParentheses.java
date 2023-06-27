import java.util.*;

public class MismatchedParentheses {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        io.nextInt();  // discard n
        var s = io.nextStr().toCharArray();
        io.close();

        var indexStore = new LinkedList<Integer>();
        var result = new StringBuilder();
        for (int i = 0, len = s.length; i < len; i++) {
            if (s[i] == '(') {
                result.append(s[i]);
                indexStore.add(i);
            }
            else  if (s[i] == ')') {
                if (indexStore.isEmpty()) {
                    // 括弧が閉じていない場合
                    result.append(s[i]);
                } else {
                    // 括弧が閉じている場合
                    int last = indexStore.removeLast();

                    // last 番目以降の文字を削除
                    result = new StringBuilder(result.substring(0, last));
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