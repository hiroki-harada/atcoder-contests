import java.util.*;

public class GlassAndMug {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int k = in.nextInt();
        int g = in.nextInt();
        int m = in.nextInt();
        in.close();

        int glass = 0;
        int mug = 0;
        while (k-- > 0) {
            if (glass == g) {
                glass = 0;
            } else if (mug == 0) {
                mug = m;
            } else {
                int move = Math.min(g-glass, mug);
                glass += move;
                mug -= move;
            }
        }

        System.out.println(glass + " " + mug);
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
    }
}