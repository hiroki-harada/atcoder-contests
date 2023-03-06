import java.util.*;

public class FourVariables {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        io.close();

        /*
         * <実装方針>
         * X + Y = N として、X = AB を満たすA, B の数cntX Y = CD を満たすC, D の数cntYをそれぞれ求める
         * A ≦ B とすると、0 ≦ A ≦ √X の範囲を探せばよい
         */
        long result = 0;
        for (int i = 0; i < n; i++) {
            int ab = i;
            int cd = n - ab;
        }
        io.output(result);

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
        private void output(long result) {System.out.println(result);}
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