import java.util.*;

public class TakahashiSan {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        String s = in.nextStr();
        in.nextStr(); // discard t
        in.close();

        System.out.println(s + " san");
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private String nextStr() {return this.sc.next();}
    }
}