import java.util.*;

public class SleepLog {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();

        int n = io.nextInt();
        Integer[] a = new Integer[n];
        // fa[i] := a[i] 分までに何分寝たか
        Integer[] fa = new Integer[n];

        a[0] = io.nextInt();
        fa[0] = a[0];
        for (int i = 1; i < n; i++) {
            int ai = io.nextInt();
            a[i] = ai;

            // 就寝時の累計睡眠時間 = 起床時と同じ値
            if (i%2 == 1) fa[i] = fa[i-1];
            // 起床時の累計睡眠時間
            else fa[i] = fa[i-1] + a[i] - a[i-1];
        }

        int q = io.nextInt();
        int[] l = new int[q];
        int[] r = new int[q];
        for (int i = 0; i < q; i++) {
            l[i] = io.nextInt();
            r[i] = io.nextInt();
        }
        io.close();

        List<Long> result = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            result.add(fx(a, fa, r[i]) - fx(a, fa, l[i]));
        }

        io.outputList(result, "\n");
    }

    // fx := x 分までに何分寝たか
    private static long fx(Integer[] a, Integer[] fa, int x) {
        // aj <= x <= aj+1 となるj を求める
        int j = ~Collections.binarySearch(Arrays.asList(a), x, ((m, n) -> m.compareTo(n) > 0 ? 1 : -1)) - 1;
        System.out.println("j = " + j);

        // j が上限を超えないための小細工
        j = Math.min(j, a.length-2);
        // y = y0 + (x - x0) * a を解く
        return fa[j] + (x - a[j]) * (fa[j+1] - fa[j]) / (a[j+1] - a[j]);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private <T> void outputList(List<T> list, String delimiter) {
            StringBuilder result = new StringBuilder();
            for (T e : list)  result.append(e).append(delimiter);
            System.out.println(result.toString().substring(0, result.length()-delimiter.length()));
        }
    }
}