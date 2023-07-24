import java.util.*;

public class FindIt {

    static List<List<Integer>> graph;
    static boolean[] isVisited;
    static LinkedList<Integer> roop;

    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int i = 1; i <= n; i++) {
            int ai = io.nextInt();
            graph.get(i).add(ai);
        }
        io.close();

        roop = new LinkedList<>();
        isVisited = new boolean[n+1];

        for (int i = 0; i < args.length; i++) {
            if (dfs(i)) break;
        }

        // 既出の点の次から末尾の点までを答えのリストに設定
        // a -> b -> c -> d -> b
        // c, d, b を取り出す
        List<Integer> result = new ArrayList<>();
        int start = roop.getLast();
        for (int i = start+1; i < roop.size(); i++) {
            result.add(roop.get(i));
        }

        io.output(result.size());
        io.outputList(result, " ");
    }

    private static boolean dfs(int current) {
        if (isVisited[current]) return false;
        roop.add(current);
        isVisited[current] = true;

        for (int next : graph.get(current)) {
            if (!isVisited[next]) {
                if (dfs(next)) return true;
            } else if (roop.contains(next)) {
                // 閉路を見つけたら、main まで戻る
                roop.add(next);
                return true;
            }
        }

        roop = new LinkedList<>();
        return false;
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private void output(int result) {System.out.println(result);}
        private <T> void outputList(List<T> list, String delimiter) {
            StringBuilder result = new StringBuilder();
            for (T e : list)  result.append(e).append(delimiter);
            System.out.println(result.toString().substring(0, result.length()-delimiter.length()));
        }
    }
}