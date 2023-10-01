import java.util.*;

public class WhoIsSaikyo {

    static List<List<Integer>> graph;

    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int m = io.nextInt();
        // 最強のプログラマーを特定するための情報量が明らかに足りない場合、処理終了
        if (n-m > 1) {
            io.output(-1);
            return;
        }

        // 根を最強のプログラマーとするグラフを作成する
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int a = io.nextInt()-1;
            int b = io.nextInt()-1;
            graph.get(a).add(b);
        }
        io.close();

        // 任意の頂点iを始点としてDFSしたとき
        // 全ての頂点を訪問できたら、iが最強のプログラマー
        int result = -1;
        for (int i = 0; i < n; i++) {
            // 頂点i を始点としたDFS
            boolean[] isVisited = new boolean[n];
            dfs(i, isVisited);

            // 全ての頂点が訪問済となったか判定
            boolean isOk = true;
            for (boolean b : isVisited) {
                if (!b) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                result = i + 1;
                break;
            }
        }

        io.output(result);
    }

    /*
     * 訪問した頂点をチェックするDFS
     */
    private static void dfs(int current, boolean[] isVisited) {
        isVisited[current] = true;

        for (int next : graph.get(current)) {
            if (isVisited[next]) continue;
            dfs(next, isVisited);
        }
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private void output(int result) {System.out.println(result);}
    }
}