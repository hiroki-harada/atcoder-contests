import java.util.*;

public class LRUDInstructions2 {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        char[] s = io.nextStr().toCharArray();
        io.close();

        int x = 0, y = 0;
        Set<Integer> history = new HashSet<>();
        history.add(0);
        for (int i = 0, length = s.length; i < length; i++) {
            if (s[i] == 'R') ++x;
            if (s[i] == 'L') --x;
            if (s[i] == 'U') ++y;
            if (s[i] == 'D') --y;

            int locale = x*n + y;
            if (!history.add(locale)) {
                io.output("Yes");
                return;
            }
        }
        io.output("No");
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
        private <T> void output(T result) {System.out.println(result);}
    }
}