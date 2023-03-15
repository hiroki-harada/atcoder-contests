import java.util.*;

public class RoadToPromotion {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 1; i <= n+1; i++) graph.add(new ArrayList<>());
        for (int i = 1; i <= n; i++) {
            int a = io.nextInt();
            // 上司a -> 部下i の方向に線を追加
            graph.get(a).add(i);
        }
        io.close();

        // dp[i] := 社員i の部下の数
        int[] dp = new int[n+1];

        // 初期値 0(int のデフォルト値)

        // 漸化式
        // dp[i] =
        for (int i = n; i >= 1; i--) {
            for (int j = 0, size = graph.get(i).size(); j < size; j++) {
                dp[i] += dp[graph.get(i).get(j)] + 1;
            }
        }

        io.outputIntArray(dp, " ");
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
}