import java.util.*;

public class QualB {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int k = io.nextInt();
        char[] s = io.nextStr().toCharArray();
        io.close();

        String result = "";
        for (int i = 0; i < n; i++) {
            // 参加希望者が上限に達した場合
            if (k == 0) {
                result += "x";
                continue;
            }

            // 参加希望している
            if (s[i] == 'o') {
                result += s[i];
                k--;
            } else {
            // 参加希望していない
                result += "x";
            }
        }
        io.output(result);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
        private <T> void output(T result) {System.out.println(result);}
    }
}