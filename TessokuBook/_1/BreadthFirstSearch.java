import java.util.*;

public class BreadthFirstSearch {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int r = io.nextInt();
        int c = io.nextInt();
        // 設問には、sy sx と記載されているため注意
        int sx = io.nextInt()-1;
        int sy = io.nextInt()-1;
        int gx = io.nextInt()-1;
        int gy = io.nextInt()-1;
        String[] cr = io.nextStrArray(r);
        io.close();

        /*
         * <方針>
         * 迷路内の隣接する空きマスに辺が張られていると解釈し、
         * 縦方向/横方向それぞれの辺をグラフに記録する
         *
         * また、マス(i, j)の頂点番号を、i*C + j とする(0<=i<R, 0<=j<C)
         */

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < r*(c+1); i++) graph.add(new ArrayList<>());

        /* 横方向の辺を追加 */
        // 任意の1行において
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c-1; j++) {
                // 横方向に隣接するマスの頂点を選ぶ
                int box1 = i*c + j;
                int box2 = i*c + j+1;
                // 選んだマス同士が空きマスの場合
                if (cr[i].charAt(j) == '.' && cr[i].charAt(j+1) == '.') {
                    // グラフに辺を追加する
                    graph.get(box1).add(box2);
                    graph.get(box2).add(box1);
                }
            }
        }

        /* 縦方向の辺を追加 */
        for (int i = 0; i < r-1; i++) {
            for (int j = 0; j < c; j++) {
            // 任意の1列において
                // 縦方向に隣接するマスの頂点を選ぶ
                int box1 =  i   *c + j;
                int box2 = (i+1)*c + j;
                // 選んだマス同士が空きマスの場合
                if (cr[i].charAt(j) == '.' && cr[i+1].charAt(j) == '.') {
                    // グラフに辺を追加する
                    graph.get(box1).add(box2);
                    graph.get(box2).add(box1);
                }
            }
        }

        /* BFS 初期化 */
        int[] dist = new int[r*c];
        for (int i = 0; i < r*c; i++) dist[i] = -1;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(sx*c + sy);
        dist[sx*c + sy] = 0;

        // BFS
        while (!queue.isEmpty()) {
            int current = queue.removeFirst();
            for (int i = 0, size = graph.get(current).size(); i < size; i++) {
                int next = graph.get(current).get(i);
                if (dist[next] != -1) continue;
                dist[next] = dist[current] + 1;
                queue.add(next);
            }
        }

        io.output(dist[gx*c + gy]);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String[] nextStrArray(int size) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < size; i++) list.add(this.sc.next());
            return list.toArray(new String[size]);
        }
        private void output(int result) {System.out.println(result);}
    }
}