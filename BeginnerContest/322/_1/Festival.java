import java.util.*;

public class Festival {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = in.nextIntArray(m);
        in.close();

        // 花火が上がる日：1, 花火が上がらない日：0
        int[] aryFireWorksDays = new int[n];
        for (int aa : a) aryFireWorksDays[aa-1] = 1;

        // 最終日から順に求めることで、下記のような部分的に昇順な数列として算出できる(O(N))
        // 0, 1, 2, 3, 0, 1, 2, 0, ...
        String[] result = new String[n];
        int offsetDays = 0;
        for (int i = n-1; i >= 0; i--) {
            if (aryFireWorksDays[i] == 1) {
                result[i] = "0";
                offsetDays = 0;
            } else {
                result[i] = String.valueOf(++offsetDays);
            }
        }

        System.out.println(String.join("\n", result));
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