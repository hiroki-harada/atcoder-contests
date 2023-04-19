import java.util.*;

public class JobInterview {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        String s = io.nextStr();
        io.close();

        String result = "No";
        while (--n >= 0) {
            if (s.charAt(n) == 'o') result = "Yes";
            if (s.charAt(n) == 'x') {
                result = "No";
                break;
            }
        }
        io.output(result);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
        private <T> void output(T result) {System.out.println(result);}
    }
}