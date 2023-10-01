import java.util.*;

public class RotateColoredSubsequence {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int m = io.nextInt();
        char[] s = io.nextStr().toCharArray();
        int[] c = new int[n];
        // 色をキーに、色の出現回数をバリューにマッピング
        Map<Integer, Integer> cntShift = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int ci = io.nextInt();

            c[i] = ci;
            int cnt = cntShift.getOrDefault(cntShift, 0);
            cntShift.put(ci, ++cnt);
        }
        io.close();

        for (var e : cntShift.entrySet()) {
            int color = e.getValue();
        }
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private long nextLong() {return this.sc.nextLong();}
        private String nextStr() {return this.sc.next();}
        private int[] nextIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) array[i] = this.sc.nextInt();
            return array;
        }
        private int[][] nextIntArray(int size1, int size2) {
           int[][] array = new int[size1][size2];
           for (int i = 0; i < size1; i++) array[i] = nextIntArray(size2);
           return array;
        }
        private long[] nextLongArray(int size) {
            long[] array = new long[size];
            for (int i = 0; i < size; i++) array[i] = this.sc.nextLong();
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
        private <T> void outputList(List<T> list, String delimiter) {
            StringBuilder result = new StringBuilder();
            for (T e : list)  result.append(e).append(delimiter);
            System.out.println(result.toString().substring(0, result.length()-delimiter.length()));
        }
    }
}