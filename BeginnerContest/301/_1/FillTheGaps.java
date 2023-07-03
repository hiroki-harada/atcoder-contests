import java.util.*;

public class FillTheGaps {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int[] a = io.nextIntArray(n);
        io.close();

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n-1; i++) {
            result.add(a[i]);
            if (Math.abs(a[i]-a[i+1]) == 1) continue;

            if (a[i] < a[i+1]) {
                for (int j = a[i]+1; j < a[i+1]; j++) result.add(j);
            }
            if (a[i] > a[i+1]) {
                for (int j = a[i]-1; j > a[i+1]; j--) result.add(j);
            }
        }
        result.add(a[n-1]);

        io.outputList(result, " ");
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