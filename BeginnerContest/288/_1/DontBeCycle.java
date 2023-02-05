import java.util.*;

public class DontBeCycle {
    static List<List<Integer>> graph = null;
    static boolean[] isVisited = null;
    public static void main(String[] args) {

        // 残すことのできる辺の本数の最大値Lについて考える
        // > M-L が削除する必要のある辺の数

        // グラフにおける、頂点数がXiの任意の連結成分 Si について
        // 閉路ができない最大の辺の数は、Xi-1 本
        // > グラフ全体の辺の本数は、グラフの連結成分の数をSとすると L = X1-1 + X2-1 + ... + Xs-1
        // > グラフ全体の頂点数は N = X1 + X2 + ... + Xs より、 L = N-S
        // > M-N+S が削除する必要のある辺の数

        // > 連結成分の数、すなわち、DFS/BFSした回数を求めればよい

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int m = io.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = io.nextInt()-1;
            int v = io.nextInt()-1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        io.close();

        int s = 0;
        isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (isVisited[i]) continue;
            dfs(i);
            s++;
        }
        io.output(m-n+s);
    }

    private static void dfs(int current) {
        isVisited[current] = true;
        for (Integer next : graph.get(current)) {
            if (isVisited[next]) continue;
            dfs(next);
        }
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private void output(int result) {System.out.println(result);}
    }
}