import java.util.*;

public class ExtendedABC {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        String s = in.nextStr();
        in.close();

        System.out.println(s.matches("A*B*C*") ? "Yes" :"No");
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private String nextStr() {return this.sc.next();}
    }
}