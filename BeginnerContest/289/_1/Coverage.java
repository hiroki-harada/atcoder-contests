import java.util.*;

public class Coverage {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int m = io.nextInt();
        List<List<Integer>> s = new ArrayList<>();
        for (int i = 0; i < m; i++) s.add(new ArrayList<>());

        for (List<Integer> list : s) {
            int ci = io.nextInt();
            while (ci-- > 0) list.add(io.nextInt());
        }
        io.close();

        // dp[i][j] :=  S1~Si までの集合の中からいくつかを選択した場合に、条件を満たす場合の数j
        boolean[] dp = new boolean[m];

        // 初期値
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            if (!s.get(0).contains(i)) {
                dp[0] = false;
                break;
            }
        }

        // 漸化式
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

            }
        }
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