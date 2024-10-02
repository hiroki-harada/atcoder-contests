import java.util.*;

public class RoadToPromotionHard {
    static List<List<Integer>> graph;
    static boolean[] isVisited;
    static int[] result;
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int t = io.nextInt()-1;
        int[] a = new int[n-1];
        int[] b = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            a[i] = io.nextInt()-1;
            b[i] = io.nextInt()-1;
        }
        io.close();

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < n-1; i++) {
            // 上司 <-> 部下 の双方向に辺を追加
            graph.get(a[i]).add(b[i]);
            graph.get(b[i]).add(a[i]);
        }

        result = new int[n];
        isVisited = new boolean[n];

        dfs(t);

        io.outputIntArray(result, " ");
    }

    /*
     * ret dfs(int current): 社員current の部下をDFSで探索して、直属？の部下の階級retを求める
     */
    private static int dfs(int current) {
        isVisited[current] = true;
        result[current] = 0;

        for (int next : graph.get(current)) {
            if (isVisited[next]) continue;

            int ret = dfs(next);
            result[current] = Math.max(result[current], ret + 1);
        }

        return result[current];
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