import java.util.*;

public class SimilarString {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        String s = io.nextStr();
        String t = io.nextStr();
        io.close();

        while (--n >= 0) {
            if (s.charAt(n) == t.charAt(n)) continue;
            if (s.charAt(n) == '0' && t.charAt(n) == 'o') continue;
            if (s.charAt(n) == '1' && t.charAt(n) == 'l') continue;
            if (t.charAt(n) == '0' && s.charAt(n) == 'o') continue;
            if (t.charAt(n) == '1' && s.charAt(n) == 'l') continue;

            io.output("No");
            return;
        }
        io.output("Yes");
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
        private <T> void output(T result) {System.out.println(result);}
    }
}