import java.util.*;

public class PrefixAndSuffix {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        io.nextInt(); // discard n
        io.nextInt(); // discard m
        String s = io.nextStr();
        String t = io.nextStr();
        io.close();

        if (t.startsWith(s)) {
            if (t.endsWith(s)) {
                io.output(0);
            } else {
                io.output(1);
            }
        } else if (t.endsWith(s)) {
            io.output(2);
        } else {
            io.output(3);
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