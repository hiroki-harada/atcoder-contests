import java.util.*;

public class Alternately {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        String s = io.nextStr();
        io.close();

        for (int i = 0; i < n-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                io.output("No");
                return;
            }
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