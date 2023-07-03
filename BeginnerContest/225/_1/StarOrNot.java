import java.util.*;

public class StarOrNot {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        var n = io.nextInt();
        var graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < n-1; i++) {
            int a = io.nextInt()-1;
            int b = io.nextInt()-1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        io.close();

        for (int i = 0; i < n; i++) {
            int size = graph.get(i).size();
            if (size == n-1) {
                io.output("Yes");
                return;
            }
        }
        io.output("No");
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private <T> void output(T result) {System.out.println(result);}
    }
}