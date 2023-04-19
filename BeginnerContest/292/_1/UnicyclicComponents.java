import java.util.*;

public class UnicyclicComponents {
    static List<Map<Integer, Integer>> graph = null;
    static boolean[] isVisited = null;
    static boolean[] isPassed = null;
    static int cntPoint = 0;
    static int cntString = 0;
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int m = io.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new HashMap<>());
        for (int i = 0; i < m; i++) {
            int u = io.nextInt()-1;
            int v = io.nextInt()-1;
            // 点u は、点v と辺 i で連結している
            graph.get(u).put(i, v);
            graph.get(v).put(i, u);
        }
        io.close();

        isVisited = new boolean[n];
        isPassed  = new boolean[m];
        for (int p = 0; p < n; p++) {
            cntPoint = 0;
            cntString = 0;
            if (isVisited[p]) continue;
            dfs(p);

            if (cntPoint != cntString) {
                io.output("No");
                return;
            }
        }
        io.output("Yes");
    }

    private static void dfs(int current) {
        isVisited[current] = true;
        cntPoint++;

        for (Map.Entry<Integer, Integer> nextMap : graph.get(current).entrySet()) {
            if (isPassed[nextMap.getKey()]) continue;
            isPassed[nextMap.getKey()] = true;
            cntString++;

            if (isVisited[nextMap.getValue()]) continue;

            dfs(nextMap.getValue());
        }
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private <T> void output(T result) {System.out.println(result);}
    }
}