import java.util.*;

public class ApproximateEqualization2 {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        List<Integer> a = io.nextList(n);
        io.close();

        // ポイント：不変量に注目する
        // 今回だと、操作前後の sum(a)
        // 操作後に、x, x, x, x+1, x+1, ... のような数列になる

        long cntResult = 0;

        io.output(cntResult);
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
        private void output(long result) {System.out.println(result);}
    }
}