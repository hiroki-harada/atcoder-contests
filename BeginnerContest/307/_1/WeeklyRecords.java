import java.util.*;

public class WeeklyRecords {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int[][] a = io.nextIntArray(n, 7);
        io.close();

        var result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            var tmp = 0;
            for (int j = 0; j < 7; j++) tmp += a[i][j];
            result.append(tmp).append(" ");
            if (i != n-1) result.append(" ");
        }
        io.output(result.toString());
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
        private int[][] nextIntArray(int size1, int size2) {
           int[][] array = new int[size1][size2];
           for (int i = 0; i < size1; i++) array[i] = nextIntArray(size2);
           return array;
        }
        private <T> void output(T result) {System.out.println(result);}
    }
}