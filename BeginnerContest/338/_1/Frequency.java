import java.util.*;

public class Frequency {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        String s = in.nextStr();
        in.close();

        final String CHARS = "abcdefghijklmnopqrstuvwxyz";

        char result = 'a';
        int  cntMostAppeared = 0;
        for (int i = 0; i < CHARS.length(); i++) {

            // 各文字の出現回数を数える
            int cnt = 0;
            for (int j = 0; j < s.length(); j++) {
                if (CHARS.charAt(i) == s.charAt(j)) cnt++;
            }

            // 出現回数の判定
            if (cnt > cntMostAppeared) {
                result = CHARS.charAt(i);
                cntMostAppeared = cnt;
            }
        }

        System.out.println(result);
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private String nextStr() {return this.sc.next();}
    }
}