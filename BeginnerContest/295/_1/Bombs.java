import java.util.*;

public class Bombs {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int r = io.nextInt();
        int c = io.nextInt();
        String[] b = io.nextStrArray(r);
        io.close();

        boolean[][] result = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (Character.isDigit(b[i].charAt(j))) continue;
                int bij = (int)b[i].charAt(j);

                for (int ni = 0; ni < r; ni++) {
                    for (int nj = 0; nj < c; nj++) {
                        if (Math.abs(i - ni) + Math.abs(j - nj) <= bij) result[ni][nj] = true;
                    }
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (result[i][j]) b[i] = b[i].substring(0, i) + "." + b[i].substring(i+1, b[i].length());
            }
        }
        io.outputArray(b, "\r\n");
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