import java.util.*;

public class AddOneEdge {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n1 = io.nextInt();
        int n2 = io.nextInt();
        int m = io.nextInt();

        // BFS の実装が楽になるので、グラフを分ける
        List<List<Integer>> graph1 = new ArrayList<>();  // n1 グループのグラフ
        for (int i = 0; i < n1; i++) graph1.add(new ArrayList<>());
        List<List<Integer>> graph2 = new ArrayList<>();  // n2 グループのグラフ
        for (int i = 0; i < n2; i++) graph2.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int a = io.nextInt()-1;
            int b = io.nextInt()-1;

            // n1,n2 のグループに振り分け
            if (a >= n1) {
                a -= n1;
                b -= n1;
                graph2.get(a).add(b);
                graph2.get(b).add(a);
            } else {
                graph1.get(a).add(b);
                graph1.get(b).add(a);
            }
        }
        io.close();

        /*
         * 1 から最も遠い点をl1, n1+n2 から最も遠い点をl2 とすると
         * d = l1 + l2 +1　である
         */
        int l1 = Collections.max(bfs(0, graph1));
        int l2 = Collections.max(bfs(n2-1, graph2));

        io.output(l1+l2+1);
    }

    private static List<Integer> bfs(int start, List<List<Integer>> graph) {
        Queue<Integer> que = new ArrayDeque<>();
        Integer[] dist = new Integer[graph.size()];
        Arrays.fill(dist, -1);

        dist[start] = 0;
        que.add(start);
        while (!que.isEmpty()) {
            // 先頭の値を取り出す
            int current = que.remove();
            // 隣接する全頂点を調べる
            for (int next : graph.get(current)) {
                // 距離が未定の場合、現在点+1を次点の距離とする
                if (dist[next] != -1) continue;
                dist[next] = dist[current]+1;
                que.add(next);
            }
        }

        return Arrays.asList(dist);
    }


    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private void output(int result) {System.out.println(result);}
    }
}