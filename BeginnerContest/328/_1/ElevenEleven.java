import java.util.*;

public class ElevenEleven {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        int[] d = in.nextIntArray(n);
        in.close();

        int result = 0;
        // 1桁月と2桁月に分けて集計
        for (int month = 1; month <= n; month++) {
            if (month <= 9) {
                // 1/1, 2/2, 3/3 ...
                if (d[month-1] >= month) result++;
                // 1/11, 2/22, 3/33 ...
                if (d[month-1] >= 10*month+month) result++;
            } else {
                // 2桁月は11, 22, 33... 月のみ対象
                if (month%10 != month/10) continue;

                // 11/1, 22/2, 33/3 ...
                if (d[month-1] >= month%10) result++;
                // 11/11, 22/22, 33/33 ...
                if (d[month-1] >= month) result++;
            }
        }

        System.out.println(result);
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private int[] nextIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) array[i] = this.sc.nextInt();
            return array;
        }
    }
}