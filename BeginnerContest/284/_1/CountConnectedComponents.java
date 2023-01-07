import java.util.*;

public class CountConnectedComponents {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int m = io.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = io.nextInt()-1;
            int v = io.nextInt()-1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        io.close();

        /*
         * 実装方針
         * DFS or BFS した回数 = 連結成分の数
         */
        boolean[] isVisited = new boolean[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (isVisited[i]) continue;
            dfs(i, isVisited, graph);
            result++;
        }
        io.output(result);
    }

    private static void dfs(int n, boolean[] isVisited, List<List<Integer>> graph) {
        isVisited[n] = true;
        for (Integer i : graph.get(n)) {
            if (isVisited[i]) break;
            dfs(i, isVisited, graph);
        }
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private void output(int result) {System.out.println(result);}
    }
}
