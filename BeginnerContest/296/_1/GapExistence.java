import java.util.*;

public class GapExistence {
    public static void main(String[] args) {

        /*
         * 解答方針
         * ai - aj = x より、ai = aj + x
         * a' := aj + x (1 <= j <= n) を用意する
         *
         * Set a, Set a' として
         * 2*a.size() != a'() であれば、ai = aj + x を満たす ai が存在する
         */

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        long x = io.nextLong();
        Set<Long> a = new HashSet<>();
        Set<Long> aPlusX = new HashSet<>();
        for (int i = 0; i < n; i++) {
            long ai = io.nextLong();
            a.add(ai);
            aPlusX.add(ai);
            aPlusX.add(ai + x);
        }
        io.close();

        if (a.size()*2 != aPlusX.size()) {
            io.output("Yes");
        } else {
            io.output("No");
        }

    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private long nextLong() {return this.sc.nextLong();}
        private <T> void output(T result) {System.out.println(result);}
    }
}