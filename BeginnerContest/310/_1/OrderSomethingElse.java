import java.util.*;

public class OrderSomethingElse {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int p = io.nextInt();
        int q = io.nextInt();
        List<Integer> d = io.nextList(n);
        io.close();

        int minD = Collections.min(d);

        io.output(Math.min(p, q + minD));
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