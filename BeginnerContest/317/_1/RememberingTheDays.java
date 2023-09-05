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

        io.output(0);
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
        int dist;
        int pos;
        public State(int dist, int pos) {
            this.dist = dist;
            this.pos = pos;
        }
        @Override
        public int compareTo(State s) {
            if (this.dist < s.dist) return -1;
            if (this.dist > s.dist) return  1;
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