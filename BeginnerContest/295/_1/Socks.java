import java.util.*;

public class Socks {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        List<Integer> a = io.nextList(n);
        io.close();

        int result = 0;
        var history = new HashSet<Integer>();
        for (Integer aa : a) {
            if (history.add(aa)) continue;
            result++;
            history.remove(aa);
        }
        io.output(result);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private List<Integer> nextList(int size) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) list.add(this.sc.nextInt());
            return list;
        }
        private void output(int result) {System.out.println(result);}
    }
}