import java.util.*;

public class ApproximateEqualization2 {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        List<Integer> a = io.nextList(n);
        io.close();

        // ポイント：不変量に注目する
        // 今回だと、操作前後の S = sum(a) は不変

        // 操作後の数列をソートすると、x, x, x, x+1, x+1, ... のような数列になる
        // -> S = nx + r とすると, x = S/n, r = S%n

        // A に対して操作を行った後の数列を B とする(A は操作前にソートされているとする)
        // A1, A2, ..., An-1, An, B1, B2, ..., Bn-1, Bn に対して、
        // |Ai-Bi| がなるべく小さくなるようにしたい (逆に、最小でない場合は、無駄に操作している事になる)
        // 1回の操作で、Σ|Ai-Bi| は ±2 変動するので、Σ|Ai-Bi|/2 が求める操作回数

        // という訳で、まずはソート
        Collections.sort(a);

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