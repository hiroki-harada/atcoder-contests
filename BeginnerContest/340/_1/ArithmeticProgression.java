import java.util.*;

public class ArithmeticProgression {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int a = in.nextInt();
        int b = in.nextInt();
        int d = in.nextInt();
        in.close();

        for (int ai = a; ai <= b; ai += d) System.out.print(ai + " ");
        System.out.println();
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
    }
}