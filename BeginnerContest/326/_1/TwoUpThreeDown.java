import java.util.*;

public class TwoUpThreeDown {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int x = in.nextInt();
        int y = in.nextInt();
        in.close();

        System.out.println(y-x <= 2 && y-x >= -3 ? "Yes" : "No");
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
    }
}