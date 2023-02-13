import java.util.*;

public class ChineseCharactor {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int m = io.nextInt();
        int[] a = io.nextIntArray(m);
        io.close();

        int[] re = new int[n+1];
        List<Integer> ans = new ArrayList<>();
        for (int i = 1, j = 1; i <= n; i = ++j) {
          while (re[j] == 1) j++;
          for (int k = j; k >= i; k--) ans.add(k);
        }
        io.outputArray(ans.toArray(new Integer[ans.size()]), " ");
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
        private int[] nextIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) array[i] = this.sc.nextInt();
            return array;
        }
        private String[] nextStrArray(int size) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < size; i++) list.add(this.sc.next());
            return list.toArray(new String[size]);
        }
        private void output(int result) {System.out.println(result);}
        private <T> void output(T result) {System.out.println(result);}
        private void outputIntArray(int[] array, String delimiter) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < array.length; i++)  result.append(array[i]).append(delimiter);
            System.out.println(result.toString().substring(0, result.length()-delimiter.length()));
        }
        private <T> void outputArray(T[] array, String delimiter) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < array.length; i++)  result.append(array[i]).append(delimiter);
            System.out.println(result.toString().substring(0, result.length()-delimiter.length()));
        }
    }
}