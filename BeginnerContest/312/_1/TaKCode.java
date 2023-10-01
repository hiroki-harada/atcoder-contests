import java.util.*;

public class TaKCode {

    final static char BLACK = '#';
    final static char WHITE = '.';

    static int n;
    static int m;
    static String[] s;

    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        n = io.nextInt();
        m = io.nextInt();
        s = io.nextStrArray(n);
        io.close();

        List<String> result = new ArrayList<>();
        for (int i = 0; i < n-8; i++) {
            for (int j = 0; j < m-8; j++) {

                // i,j を左上とする領域が Tak Code か判定
                if (!check(i, j)) continue;

                // Tak Code の場合、解答リストに追加
                result.add( (i+1)+ " " +(j+1) );
            }
        }

        if (result.isEmpty()) return;

        io.outputList(result, "\n");
    }

    /*
     * i,j を左上とする領域が Tak Code か判定
     */
    private static boolean check(int i, int j) {

        // 左上の黒をチェック
        for (int ii = 0; ii <= 2; ii++)
        for (int jj = 0; jj <= 2; jj++)
        if (s[i+ii].charAt(j+jj) != BLACK) return false;

        // 右下の黒をチェック
        for (int ii = 6; ii <= 8; ii++)
        for (int jj = 6; jj <= 8; jj++)
        if (s[i+ii].charAt(j+jj) != BLACK) return false;

        // 左上の白をチェック
        for (int ii = 0; ii <= 3; ii++)
        if (s[i+ii].charAt(j+3) != WHITE) return false;
        for (int jj = 0; jj <= 3; jj++)
        if (s[i+3].charAt(j+jj) != WHITE) return false;

        // 右下の白をチェック
        for (int ii = 5; ii <= 8; ii++)
        if (s[i+ii].charAt(j+5) != WHITE) return false;
        for (int jj = 5; jj <= 8; jj++)
        if (s[i+5].charAt(j+jj) != WHITE) return false;

        return true;
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String[] nextStrArray(int size) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < size; i++) list.add(this.sc.next());
            return list.toArray(new String[size]);
        }
        private <T> void outputList(List<T> list, String delimiter) {
            StringBuilder result = new StringBuilder();
            for (T e : list)  result.append(e).append(delimiter);
            System.out.println(result.toString().substring(0, result.length()-delimiter.length()));
        }
    }
}