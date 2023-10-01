import java.util.*;

public class LikeChecker {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        char[] n = io.nextStr().toCharArray();
        io.close();

        for (int i = 0, len = n.length; i < len-1; i++) {
            if (n[i] <= n[i+1]) {
                io.output("No");
                return;
            }
        }
        io.output("Yes");
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private String nextStr() {return this.sc.next();}
        private <T> void output(T result) {System.out.println(result);}
    }
}