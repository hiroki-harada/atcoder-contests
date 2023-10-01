import java.util.*;

public class FirstAbc {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        String s = io.nextStr();
        io.close();

        boolean[] isExists = new boolean[3];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'A') isExists[0] = true;
            if (s.charAt(i) == 'B') isExists[1] = true;
            if (s.charAt(i) == 'C') isExists[2] = true;

            if (isExists[0] && isExists[1] && isExists[2]) {
                io.output(i+1);
                return;
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