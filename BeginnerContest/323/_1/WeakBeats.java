import java.util.*;

public class WeakBeats {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        char[] s = in.nextStr().toCharArray();
        in.close();

        for (int i = 0; i < s.length ; i++) {
            if (i == 0 || i%2 == 0) continue;

            if (s[i] == '1') {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private String nextStr() {return this.sc.next();}
    }
}