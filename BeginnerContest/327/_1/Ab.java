import java.util.*;

public class Ab {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        String s = in.nextStr();
        in.close();

        System.out.println(
            s.replace("ab", "").replace("ba", "").length() != n ? "Yes" : "No"
        );
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
    }
}