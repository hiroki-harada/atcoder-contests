import java.util.*;

public class Lower {
    public static void main(String[] args) {

        /*
         * ポイント：最後のtoUpper/toLower のみ実行することで、O(N+Q) で処理できる
         */

        IOHandler io = new IOHandler();
        io.nextInt(); // discard n
        char[] s = io.nextStr().toCharArray();
        int q = io.nextInt();
        int[] t = new int[q];
        int[] x = new int[q];
        char[] c = new char[q];
        int last = 0;
        for (int i = 0; i < q; i++) {
            t[i] = io.nextInt();
            x[i] = io.nextInt();
            c[i] = io.nextStr().charAt(0);
            // 最後のtoUpper/toLower を保持
            if (t[i] == 2 || t[i] == 3) last = i;
        }
        io.close();

        for (int i = 0; i < q; i++) {
            if (t[i] == 1) s[ x[i]-1 ] = c[i];
            if (t[i] == 2 && i == last) s = (new String(s)).toLowerCase().toCharArray();
            if (t[i] == 3 && i == last) s = (new String(s)).toUpperCase().toCharArray();
        }

        io.output(new String(s));
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
        private <T> void output(T result) {System.out.println(result);}
    }
}