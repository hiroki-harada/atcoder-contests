import java.util.*;

public class SumOfNumbersGreaterThanMe {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        List<Long> a = in.nextLongList(n);
        in.close();

        // 事前に ai をキー、aj > ai の累積和をバリューとするmapを計算する
        Map<Long, Long> mapCumulative = new HashMap<>();
        List<Long> sortedA = a.stream().sorted((ai, aj) -> aj.compareTo(ai)).toList();
        long tmpSum = 0;
        for (int i = 0; i < n; i++) {
            long key = sortedA.get(i);
            if (null == mapCumulative.get(key)) mapCumulative.put(key, tmpSum);
            tmpSum += key;
        }

        // ai 毎に、条件を満たす和を出力
        for (int i = 0; i < n; i++) {
            System.out.print(mapCumulative.get(a.get(i)));
            if (i != n-1) System.out.print(" ");
            else System.out.println();
        }
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private List<Long> nextLongList(int size) {
            List<Long> list = new ArrayList<>();
            for (int i = 0; i < size; i++) list.add(this.sc.nextLong());
            return list;
        }
    }
}