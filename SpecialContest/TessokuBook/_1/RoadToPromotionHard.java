import java.util.*;

public class RoadToPromotionHard {
    static List<List<Integer>> graph;
    static boolean[] isChecked;
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
            graph.get(a[i]).add(b[i]);
            graph.get(b[i]).add(a[i]);
        }

        result = new int[n];
        isChecked = new boolean[n];
        dfs(t);

        io.outputIntArray(result, " ");
    }

    static void dfs(int current) {
        if (isChecked[current]) return;
        isChecked[current] = true;

        int tmp = 0;
        for (int next : graph.get(current)) {
            tmp = result[next];
            dfs(next);
        }
        result[current] = Math.max(result[current], tmp + 1);
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