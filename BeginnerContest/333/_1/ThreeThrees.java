import java.util.*;

public class ThreeThrees {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        in.close();

        String result = "";
        for (int i = 0; i < n; i++) {
            result += String.valueOf(n);
        }

        System.out.println(result);
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
    }
}