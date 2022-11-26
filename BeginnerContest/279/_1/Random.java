import java.util.*;

public class Random {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int h = io.nextInt();
        int w = io.nextInt();
        long[] s = new long[h];
        long[] t = new long[h];
        for (int i = 0; i < h; i++) {
            s[i] = io.nextStr().chars().mapToLong(str -> str == '#' ? 1l : 0l).sum();
        }
        for (int i = 0; i < h; i++) {
            t[i] = io.nextStr().chars().mapToLong(str -> str == '#' ? 1l : 0l).sum();
        }
        io.close();

        for (int i = 0; i < h; i++) {
            if (s[i] != t[i]) {
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