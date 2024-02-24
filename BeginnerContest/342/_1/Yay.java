import java.util.*;

public class Yay {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        String s = in.nextStr();
        in.close();

        int result = 0;
        if (s.charAt(0) == s.charAt(1)) {
            // AA...B... の場合
            for (int i = 2; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(0)) continue;

                result = i + 1;
                break;
            }
        } else if (s.charAt(0) == s.charAt(2)) {
            // ABA... の場合
            result = 2;
        } else {
            // ABB... の場合
            result = 1;
        }

        System.out.println(result);
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private String nextStr() {return this.sc.next();}
    }
}