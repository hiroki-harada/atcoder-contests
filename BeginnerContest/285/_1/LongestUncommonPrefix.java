import java.util.*;

public class LongestUncommonPrefix {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        char[] s = io.nextStr().toCharArray();
        io.close();

        for (int i = 1; i < n; i++) {
            for (int l = 0; l < n-i+1; l++) {
                if (l == n-i) {
                    io.output(l);
                    break;
                }
                if (s[l] == s[l+i]) {
                    io.output(l);
                    break;
                }
            }
        }
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
        private void output(int result) {System.out.println(result);}
    }
}