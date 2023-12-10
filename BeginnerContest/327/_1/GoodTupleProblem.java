import java.util.*;

public class GoodTupleProblem {

    static List<List<Integer>> graph;
    static String result;
    static int[] biGraph;

    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = in.nextIntArray(m);
        int[] b = in.nextIntArray(m);
        in.close();

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int ai = a[i]-1;
            int bi = b[i]-1;
            graph.get(ai).add(bi);
            graph.get(bi).add(ai);
        }

        // biGraph[i] = -1: 未訪問、0 or 1: 訪問済
        biGraph = new int[n];
        Arrays.fill(biGraph, -1);

        result = "Yes";
        for (int i = 0; i < n; i++) {
            // 未訪問箇所は、0 と決め打ちする
            // i 回目のループで探索する場所は、i-1回目までのループで探索済の場所と繋がっていないため、決め打ちして問題ない
            if (biGraph[i] == -1) dfs(i, 0);
        }

        System.out.println(result);
    }

    private static void dfs(int current, int bit) {
        biGraph[current] = bit;

        // 隣接する点を探索
        for (int next : graph.get(current)) {
            if (biGraph[next] == -1) {
                // 未探索なら、0->1 or 1->0 に変換して、再帰的に探索
                dfs(next, 1-bit);

            } else if (biGraph[current] == biGraph[next]) {
                // 探索済で同値になったら、処理終了
                result = "No";
                return;
            }
        }
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private int[] nextIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) array[i] = this.sc.nextInt();
            return array;
        }
    }
}