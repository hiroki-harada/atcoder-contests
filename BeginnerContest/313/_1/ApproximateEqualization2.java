import java.util.*;

public class ApproximateEqualization2 {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        long[] a = io.nextLongArray(n);
        io.close();

        // ポイント：不変量に注目する
        // 今回だと、操作前後の S = sum(a) は不変

        // 操作後の数列をソートすると、x, x, x, x+1, x+1, ... のような数列になる
        // -> S = nx + r とすると, x = S/n, r = S%n・・・★

        // A に対して操作を行った後の数列を B とする(A は操作前にソートされているとする)
        // A1, A2, ..., An-1, An, B1, B2, ..., Bn-1, Bn に対して、
        // |Ai-Bi| がなるべく小さくなるようにしたい (逆に、最小でない場合は、無駄に操作している事になる)
        // 1回の操作で、Σ|Ai-Bi| は +2 変動するので、Σ|Ai-Bi|/2 が求める操作回数
        // さらに、その中でも、操作回数が最小になるものを求めればよい

        long sum = Arrays.stream(a).sum();
        Arrays.sort(a);
        long[] b = new long[n];
        Arrays.fill(b, sum/n);
        for (int i = 0; i < sum%n; i++) b[n - 1 - i]++;

        long result = 0;
        for (int i = 0; i < n; i++) result += Math.abs(a[i] - b[i]);
        io.output(result/2);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private long[] nextLongArray(int size) {
            long[] array = new long[size];
            for (int i = 0; i < size; i++) array[i] = this.sc.nextLong();
            return array;
        }
        private void output(long result) {System.out.println(result);}
    }
}