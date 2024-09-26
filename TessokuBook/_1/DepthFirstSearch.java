import java.util.*;

public class DepthFirstSearch {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int m = io.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int a = io.nextInt()-1;
            int b = io.nextInt()-1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        io.close();

        boolean[] isVisited = new boolean[n];
        dfs(0, graph, isVisited);

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                io.output("The graph is not connected.");
                return;
            }
        }
        io.output("The graph is connected.");
    }

    private static void dfs(int current, List<List<Integer>> graph, boolean[] isVisited) {
        isVisited[current] = true;
        for (int i = 0, size = graph.get(current).size(); i < size; i++) {
            int next = graph.get(current).get(i);
            if (!isVisited[next]) dfs(next, graph, isVisited);
        }
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private <T> void output(T result) {System.out.println(result);}
    }
}