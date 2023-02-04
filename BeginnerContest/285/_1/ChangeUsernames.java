import java.util.*;

public class ChangeUsernames {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        Map<String, String> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(io.nextStr(), io.nextStr());
        }
        io.close();

        for (String key : graph.keySet()) {
            String root = key;
            while (true) {
                String next = graph.get(key);
                if (next == null) break;
                if (root.equals(next)) {
                    // グラフにサイクルが存在しているので、変更不可
                    io.output("No");
                    return;
                }
                graph.put(key, null);
                key = next;
            }
        }
        io.output("Yes");
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
        private <T> void output(T result) {System.out.println(result);}
    }
}