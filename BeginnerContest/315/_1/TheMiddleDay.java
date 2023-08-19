import java.util.*;

public class TheMiddleDay {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int m = io.nextInt();
        int[] d = io.nextIntArray(m);
        io.close();

        int middleDay = (Arrays.stream(d, 0, m).sum() + 1)/2;

        /*
        * cumulativeDay <= middleDay を満たす最大のcumulativeDay を探す
        * month+1 番目の月の middleDay - cumulativeDay 番目の日が答え
        * ex) middleDay = 183, 1,2,3,4,5,6 番目の月に含まれる日数の合計は181 日 の時
        * 答えは 7 番目の月の2 番目の日
        */
        int a = 1, b = middleDay;
        int cumulativeDay = 0;
        for (int month = 0; month < m; month++) {
            if (cumulativeDay + d[month] >= middleDay) {
                a = month+1;
                b = middleDay - cumulativeDay;
                break;
            }
            cumulativeDay += d[month];
        }

        io.output(a + " " + b);
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
        private <T> void output(T result) {System.out.println(result);}
    }
}