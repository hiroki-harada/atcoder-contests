import java.util.*;

public class RememberingTheDays {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int m = io.nextInt();
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int a = io.nextInt()-1;
            int b = io.nextInt()-1;
            int c = io.nextInt();
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }
        io.close();

        int[] current = new int[n];
        boolean[] isDecided = new boolean[n];
        Queue<State> priorityQue = new ArrayDeque<>();

        // 初期化
        current[0] = 0;
        Arrays.fill(current, Integer.MAX_VALUE);
        priorityQue.add(new State(current[0], 0));

        while (!priorityQue.isEmpty()) {
            // 未到達の点を取り出す
            int cur = priorityQue.remove().position;
            if (isDecided[cur]) continue;

            isDecided[cur] = true;
            for (int i = 0, size = graph.get(cur).size(); i < size; i++) {
                Edge edge = graph.get(cur).get(i);
                if (current[edge.to] < current[cur] + edge.length) {
                    current[edge.to] = current[cur] + edge.length;
                    priorityQue.add(new State(current[edge.to], edge.to));
                }
            }
        }

        io.output(Arrays.stream(current).sum());
    }

    /**
     * 重み付きグラフの辺のクラス
     */
    static class Edge {
        int to;
        int length;
        public Edge(int to, int length) {
            this.to = to;
            this.length = length;
        }
    }

    /**
     * ダイクストラ法の (cur[x], x) を管理するクラス（cur[x] = dist, x = pos に対応）
     */
    static class State implements Comparable<State> {
        int distance;
        int position;
        public State(int dist, int pos) {
            this.distance = dist;
            this.position = pos;
        }
        @Override
        public int compareTo(State s) {
            if (this.distance < s.distance) return -1;
            if (this.distance > s.distance) return  1;
            return 0;
        }
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private void output(long result) {System.out.println(result);}
    }
}