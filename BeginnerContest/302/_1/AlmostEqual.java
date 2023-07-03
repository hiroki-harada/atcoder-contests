import java.util.*;

public class AlmostEqual {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int m = io.nextInt();
        String[] s = io.nextStrArray(n);
        io.close();

        Arrays.sort(s);

        do {
            boolean isEachMatch = true;

            // 1≤i≤N−1 を満たす全ての整数 i に対して、
            // Ti を1 文字だけ別の英小文字に変えて Ti+1 にすることが出来る かチェック
            for (int i = 0; i < n-1; i++) {
                int cntDiff = 0;
                for (int j = 0; j < m; j++) {
                    if (s[i].charAt(j) != s[i+1].charAt(j)) cntDiff++;
                }
                isEachMatch &= cntDiff == 1;
            }

            // 全ての文字について成り立つ場合
            if (isEachMatch) {
                io.output("Yes");
                return;
            }
        } while (Permutation.nextPermutation(s));

        io.output("No");
    }

    private static class Permutation {

        public static <T extends Comparable<T>> boolean nextPermutation(T[] array) {

            // 配列を右から走査し、辞書順として array[i-1] < array[i] となる i を探す
            // array[i-1] >= array[i] (i > 0) であるうちは、走査を続ける
            int i = array.length - 1;
            while (i > 0 && compare(array[i - 1], array[i]) >= 0) i--;

            // 最後の組み合わせの場合
            if (i <= 0) return false;

            // array[j] := array[i - 1] より右にあり、array[j] > array[i-1] を満たす
            int j = array.length - 1;
            while (compare(array[j], array[i - 1]) <= 0) j--;

            swap(array, i-1, j);

            // i より右側の要素を昇順ソートする
            reverse(array, i, array.length - 1);

            return true;
        }

        private static <T> void reverse(T[] array, int start, int end) {
            while (start < end) {
                swap(array, start, end);
                start++;
                end--;
            }
        }

        private static <T extends Comparable<T>> int compare(T a, T b) {
            return a.compareTo(b);
        }

        private static <T> void swap(T[] array, int m, int n) {
            T temp = array[m]; array[m] = array[n]; array[n] = temp;
        }
    }


    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String[] nextStrArray(int size) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < size; i++) list.add(this.sc.next());
            return list.toArray(new String[size]);
        }
        private <T> void output(T result) {System.out.println(result);}
    }
}