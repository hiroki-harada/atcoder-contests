import java.util.*;

public class CallTheIDNumber {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        // xi := 人iは、呼び出し済
        int[] x = new int[n+1];
        for (int i = 1; i <= n; i++) x[i] = i;

        for (int i = 1; i <= n; i++) {
            int ai = io.nextInt();
            // 人i が呼び出されていない場合、ai の番号を呼ぶ
            if (x[i] != 0) x[ai] = 0;
        }
        io.close();

        StringBuilder result = new StringBuilder();
        int k = 0;
        for (int i = 1; i <= n; i++) {
            if (x[i] != 0) {
                result.append(x[i]).append(" ");
                k++;
            }
        }

        io.output(k);
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