import java.util.*;

public class EasyGraphProblem {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int m = io.nextInt();
        var graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int a = io.nextInt()-1;
            int b = io.nextInt()-1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        io.close();

        int resulut = 0;
        // n-1, n-2, ..., 1, 0 の順に、各頂点の隣接頂点を調べ、下記を満たす頂点を数え上げる
        // 「自分自身より頂点番号が小さい隣接頂点がちょうど1 つ存在する」
        while (n-- > 0) {

            int countMatch = 0;
            for (var p : graph.get(n)) {
                if (p < n) countMatch++;
            }

            if (countMatch == 1) resulut++;
        }

        io.output(resulut);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private void output(int result) {System.out.println(result);}
    }
}