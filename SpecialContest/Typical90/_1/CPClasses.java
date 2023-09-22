import java.util.*;

public class CPClasses {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int[] a = io.nextIntArray(n);
        int q = io.nextInt();
        int[] b = io.nextIntArray(q);
        io.close();

        Arrays.sort(a);

        var result = new ArrayList<Integer>();
        for (int i = 0; i < q; i++) {

            if (b[i] <= a[0]) {
                result.add(Math.abs(a[0]-b[i]));
            } else if (b[i] >= a[a.length-1]) {
                result.add(Math.abs(a[a.length-1]-b[i]));
            } else {
                int idx = Arrays.binarySearch(a, b[i]);
                if (idx >= 0) {
                    // |aj-bi| = 0 になる値を見つけた場合
                    result.add(0);
                } else {
                    // idx = -(j+1), j := aj-bi < 0 となる最初のインデックス
                    int j = -idx -1;
                    result.add(
                        Math.min(Math.abs(a[j-1]-b[i]), Math.abs(a[j]-b[i]))
                    );
                }
            }
        }

        io.outputList(result, "\n");
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private int[] nextIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) array[i] = this.sc.nextInt();
            return array;
        }
        private <T> void outputList(List<T> list, String delimiter) {
            StringBuilder result = new StringBuilder();
            for (T e : list)  result.append(e).append(delimiter);
            System.out.println(result.toString().substring(0, result.length()-delimiter.length()));
        }
    }
}