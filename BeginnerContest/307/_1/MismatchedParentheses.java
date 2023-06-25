import java.util.*;

public class MismatchedParentheses {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        io.nextInt();  // discard n
        String s = io.nextStr();
        io.close();

        long cntRight = s.chars().filter(c -> c == '(').count();
        while (cntRight-- > 0) {
            String t = s.replaceAll("\\([a-z]{0,}\\)", "");
            if (t.equals(s)) break;
            s = t;
        }
        io.output(s);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
        private <T> void output(T result) {System.out.println(result);}
    }
}