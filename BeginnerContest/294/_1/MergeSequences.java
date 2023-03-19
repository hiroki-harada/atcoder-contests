import java.util.*;

public class MergeSequences {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int m = io.nextInt();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        Map<Integer, Character> c = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int tmp = io.nextInt();
            a.add(tmp);
            c.put(tmp, 'a');
        }
        for (int i = 0; i < m; i++) {
            int tmp = io.nextInt();
            b.add(tmp);
            c.put(tmp, 'b');
        }
        io.close();

        // キーの自然順序付けに従ってソート
        c = new TreeMap<>(c);

        StringBuilder resultA = new StringBuilder();
        StringBuilder resultB = new StringBuilder();

        // c における ai, bj の順番を、a, b どちらに属していたかのみで判定する(ckが何であるかは見ない)
        // a.contains(ck) で求めると、O(n^2) になるため
        int i = 1;
        for (Map.Entry<Integer, Character> e : c.entrySet()) {
            if (e.getValue() == 'a')
            resultA.append(i).append(" ");
            else if (e.getValue() == 'b')
                resultB.append(i).append(" ");

            i++;
        }

        io.output(resultA.toString());
        io.output(resultB.toString());
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private <T> void output(T result) {System.out.println(result);}
    }
}