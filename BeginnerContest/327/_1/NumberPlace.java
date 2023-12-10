import java.util.*;

public class NumberPlace {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int[][] a = in.nextIntArray(9, 9);
        in.close();

        // 各行の判定
        if (!isValid(a)) {
            System.out.println("No");
            return;
        }

        // 各列の判定
        int[][] tranA = transport(a);
        if (!isValid(tranA)) {
            System.out.println("No");
            return;
        }

        // 各3x3マスの判定
        int[][] transformA = transform(a);
        if (!isValid(transformA)) {
            System.out.println("No");
            return;
        }

        System.out.println("Yes");
    }

    /*
     * 1 以上9 以下の整数がちょうど1 個ずつ書き込まれているか判定
     * 前提：1未満、9より大きい値は含まれていない
     */
    private static boolean isValid(int[][] grid) {
        for (int[] row : grid) {
            if (!isValid(row)) return false;
        }
        return true;
    }
    private static boolean isValid(int[] row) {
        Set<Integer> set = new HashSet<>();

        for (int num : row) {
            if (!set.add(num)) return false;
        }
        return true;
    }

    /*
     * 転置行列を返す
     */
    private static int[][] transport(int[][] array) {
        int[][] result = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                result[j][i] = array[i][j];
            }
        }
        return result;
    }

    /*
     * 9x9の行列を書きのように変形する
     *
     * in)
     *      a11 a12 a13 a14 ... a18 a19
     *      a21 a22 a23 a24 ... a28 a29
     *      ...
     *      a91 a92 a93 a94 ... a98 a99
     * out)
     *      a11 a21 a13 a21 ... a23 a33
     *      a14 a15 a16 a24 ... a35 a36
     *      ...
     *      a77 a78 a79 a87 ... a98 a99
     */
    private static int[][] transform(int[][] grid) {
        int[][] result = new int[9][9];

        int idxResult = 0;
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {

                int[] subGrid = new int[9];
                int idxGrid = 0;
                for (int row = i; row < i + 3; row++) {
                    for (int col = j; col < j + 3; col++) {
                        subGrid[idxGrid++] = grid[row][col];
                    }
                }

                result[idxResult++] = subGrid;
            }
        }

        return result;
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
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
    }
}
