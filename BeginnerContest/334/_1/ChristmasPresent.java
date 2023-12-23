import java.util.*;

public class ChristmasPresent {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int b = in.nextInt();
        int g = in.nextInt();
        in.close();

        System.out.println(b > g ? "Bat" : "Glove");
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
    }
}