import java.util.*;

public class AllAssignPointAdd {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        // 配列を使用すると、時間内に計算が完了しない
        Map<Integer, Long> diff = new HashMap<>();
        for (int i = 0; i < n; i++) diff.put(i, io.nextLong());
        int q = io.nextInt();

        long base = 0;
        while (q-- > 0) {
            int op = io.nextInt();
            if (op == 1) {
                base = io.nextLong();
                diff = new HashMap<>();
            } else if (op == 2) {
                int key = io.nextInt()-1;
                diff.put(key, io.nextLong() + diff.getOrDefault(key, 0l));
            } else {
                io.output(base + diff.getOrDefault(io.nextInt()-1, 0l));
            }
        }
        io.close();
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private long nextLong() {return this.sc.nextLong();}
        private <T> void output(T result) {System.out.println(result);}
    }
}