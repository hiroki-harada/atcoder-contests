import java.util.*;

public class StrictlySuperior {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        io.nextInt(); // discard m
        int[] p = new int[n];
        List<List<Integer>> cf = new ArrayList<>();

        // 機能数をキーに、機能Fijリストをマッピング
        for (int i = 0; i < n; i++) {
            p[i] = io.nextInt();
            int ci = io.nextInt();
            List<Integer> f = io.nextList(ci);
            cf.add(f);
        }
        io.close();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                // j 番目の商品が、i番目の上位互換であるかを調べる

                // j 番目の商品より、i番目が同じか安い場合、次のループへ
                if (p[i] < p[j]) continue;
                // j 番目の商品より、i番目がより多くの機能を持っている場合、次のループへ
                if (!cf.get(j).containsAll(cf.get(i))) continue;
                // 同一商品は除外
                if (p[i] == p[j] && cf.get(j).stream().filter(cf.get(i)::contains).count() == cf.get(j).size()) continue;

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
        private List<Integer> nextList(int size) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) list.add(this.sc.nextInt());
            return list;
        }
        private <T> void output(T result) {System.out.println(result);}
    }
}