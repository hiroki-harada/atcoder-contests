import java.util.*;

public class AdjacentVertices {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int m = io.nextInt();

        List<List<Integer>> g = new ArrayList<>();
        // List [1], [2], ... , [n] を作成するために、n+1 回ループを回す必要があることに注意
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int a = io.nextInt();
            int b = io.nextInt();
            g.get(a).add(b);
            g.get(b).add(a);
        }
        io.close();

        for (int i = 1; i <= n; i++) {
            StringBuilder result = new StringBuilder();
            List<Integer> list = g.get(i);
            // Collections.sort(list);

            result.append(i).append(": {").append(list.get(0));
            for (int j = 1, size = list.size(); j < size; j++) {
                result.append(", ").append(list.get(j));
            }
            result.append("}");

            io.output(result.toString());
        }
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private <T> void output(T result) {System.out.println(result);}
    }
}