import java.util.*;

public class WrongAnswer {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int a = in.nextInt();
        int b = in.nextInt();
        in.close();

        // 0 or 1 のいずれかを出力する
        System.out.println(a+b == 0 ? 1 : 0);
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
    }
}