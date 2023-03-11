import java.util.*;

public class CallTheIDNumber {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int[] x = new int[n+1];
        for (int i = 1; i <= n; i++) x[i] = i;

        for (int i = 1; i <= n; i++) {
            int a = io.nextInt();
            if (x[i] != 0) {
                x[a] = 0;
            }
        }
        io.close();

        StringBuilder result = new StringBuilder();
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (x[i] != 0) {
                result.append(x[i]).append(" ");
                cnt++;
            }
        }

        io.output(cnt);
        io.output(result.toString());
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private void output(int result) {System.out.println(result);}
        private void output(String result) {System.out.println(result);}
    }
}