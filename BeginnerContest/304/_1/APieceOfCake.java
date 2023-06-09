import java.util.*;

public class APieceOfCake {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int w = io.nextInt();
        int h = io.nextInt();
        int n = io.nextInt();
        long[] p = new long[n];
        long[] q = new long[n];
        for (int i = 0; i < n; i++) {
            p[i] = io.nextLong();
            q[i] = io.nextLong();
        }
        int A = io.nextInt();
        int[] a = new int[A+1];
        for (int i = 0; i < A; i++) a[i] = io.nextInt();
        int B = io.nextInt();
        int[] b = new int[B+1];
        for (int i = 0; i < B; i++) b[i] = io.nextInt();
        io.close();

        /*
        * <方針>
        * 下記を求める
        * 1. イチゴが1コ以上乗っているピースの個数 ・・・(1)
        * 2. イチゴが1コ以上乗っているピースそれぞれの、乗っているイチゴの個数・・・(2)
        *
        * M : (2) の最大値を求める
        * m : (1) < (A+1)(B+1) の場合、m = 0, それ以外の場合、(2) の最小値を求める
        */

        a[A] = w;
        b[B] = h;





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