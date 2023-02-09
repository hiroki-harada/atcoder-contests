import java.util.*;

public class ShortestPathWithRestoration {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int m = io.nextInt();
        List<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int a = io.nextInt()-1;
            int b = io.nextInt()-1;
            int c = io.nextInt();
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }
        io.close();

        // 初期化
        boolean[] isDecided = new boolean[n];
        int[] cur = new int[n];
        Arrays.fill(cur, Integer.MAX_VALUE);

        // 初期値設定
        cur[0] = 0;
        Queue<State> que = new PriorityQueue<>();
        que.add(new State(cur[0], 0));

        while (!que.isEmpty()) {
            int current = que.remove().pos;
            if (isDecided[current]) continue;

            isDecided[current] = true;
            for (int i = 0, size = graph.get(current).size(); i < size; i++) {
                Edge e =  graph.get(current).get(i);
                if (cur[e.to] > cur[current] + e.length) {
                    cur[e.to] = cur[current] + e.length;
                    que.add(new State(cur[e.to], e.to));
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int current = n;
        result.add(current);
        while (true) {
            result.add(current);
            if (current == 1) break;

        }
        result.sort((i, j) -> j - i);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
        private int[] nextIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) array[i] = this.sc.nextInt();
            return array;
        }
        private String[] nextStrArray(int size) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < size; i++) list.add(this.sc.next());
            return list.toArray(new String[size]);
        }
        private void output(int result) {System.out.println(result);}
        private <T> void output(T result) {System.out.println(result);}
        private void outputIntArray(int[] array, String delimiter) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < array.length; i++)  result.append(array[i]).append(delimiter);
            System.out.println(result.toString().substring(0, result.length()-delimiter.length()));
        }
        private <T> void outputArray(T[] array, String delimiter) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < array.length; i++)  result.append(array[i]).append(delimiter);
            System.out.println(result.toString().substring(0, result.length()-delimiter.length()));
        }
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
            if (this.dist > s.dist) return  1;
            if (this.dist < s.dist) return -1;
            return 0;
        }
    }
}