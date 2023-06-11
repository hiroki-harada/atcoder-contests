import java.util.*;

public class SleepLog {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();

        int n = io.nextInt();
        int[] a = new int[n];
        long[] aSum = new long[n];

        a[0] = io.nextInt();
        aSum[0] = a[0];
        for (int i = 1; i < n; i++) {
            int ai = io.nextInt();
            a[i] = ai;

            // 就寝時の累計睡眠時間 = 起床時と同じ値
            if (i%2 == 0) aSum[i] = aSum[i-1];
            // 起床時の累計睡眠時間
            else aSum[i] = aSum[i-1] + a[i] - a[i-1];
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
            int idxL = calculateIndex(a, l[i], 0, false);
            int idxR = calculateIndex(a, r[i], idxL, true);

            System.out.println("idxL = " + idxL + ", idxR = " + idxR);

            result.add(aSum[idxR] - aSum[idxL]);
        }

        io.outputList(result, "\n");
    }

    private static int calculateIndex(int[] array, int value, int idxStart, boolean isLeft) {
        System.out.println("value = " + value);
        int index = idxStart;
        int min = Integer.MAX_VALUE;
        for (int i = idxStart, len = array.length; i < len; i++) {
            // value の近傍かつ、差が0以上のindexを求める
            if (0 <= array[i]-value && min > array[i]-value) {
                index = i;
                min = array[i]-value;
            }
        }
        System.out.println("index = " + index);

        if (isLeft) return Math.max(0, index-1);
        return Math.min(array.length-1, index);
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