import java.util.*;

public class Tomorrow {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int M = in.nextInt();
        int D = in.nextInt();
        int y = in.nextInt();
        int m = in.nextInt();
        int d = in.nextInt();
        in.close();

        int dd = ++d;
        if (dd > D) dd = 1;

        int mm = m;
        if (dd == 1) {
            ++mm;
            if (m == M) mm = 1;
        }

        int yy = y;
        if (m == M && dd == 1) ++yy;

        System.out.println(yy + " " + mm + " " + dd);
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
    }
}