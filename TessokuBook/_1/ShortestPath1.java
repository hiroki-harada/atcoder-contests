import java.util.*;

public class ShortestPath1 {
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

        int[] dist = new int[n];
        for (int i = 0; i < n; i++) dist[i] = -1;
        dist[0] = 0;

        Queue<Integer> que = new ArrayDeque<>();
        que.add(0);
        while (!que.isEmpty()) {
            int current = que.remove();
            for (int next : graph.get(current)) {
                if (dist[next] != -1) continue;
                dist[next] = dist[current] + 1;
                que.add(next);
            }
        }

        io.outputIntArray(dist, "\n");
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private void outputIntArray(int[] array, String delimiter) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < array.length; i++)  result.append(array[i]).append(delimiter);
            System.out.println(result.toString().substring(0, result.length()-delimiter.length()));
        }
    }
}