import java.util.*;

public class Dango {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        String s = io.nextStr();
        io.close();

        if (!s.contains("o") || !s.contains("-")) {
            io.output(-1);
            return;
        }

        int count = 0;
        int result = 1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'o') {
                count++;
            } else {
                result = Math.max(result, count);
                count = 0;
            }
        }
        io.output(Math.max(result, count));
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
        private void output(int result) {System.out.println(result);}
    }
}