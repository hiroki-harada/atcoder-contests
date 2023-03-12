import java.util.*;

public class MakeTakahashiHappy {

    static int h, w;
    static int[][] a;
    static int result = 0;

    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        h = io.nextInt();
        w = io.nextInt();
        a = new int[h][w];
        for (int i = 0; i < h; i++) for (int j = 0; j < w; j++) a[i][j] = io.nextInt();
        io.close();

        dfs(0, 0, new LinkedList<>());

        io.output(result);
    }

    static void dfs(int x, int y, LinkedList<Integer> rootHis) {
        // 通過したルートの中で、同じ番号のマスを通っている場合
        if (rootHis.contains(a[x][y])) return;
        // ゴールに到達した場合
        if (x == h - 1 && y == w - 1) {
            result++;
            return;
        }
        rootHis.add(a[x][y]);

        // 右に進める場合
        if (x < h - 1) dfs(x + 1, y, rootHis);
        // 下に進める場合
        if (y < w - 1) dfs(x, y + 1, rootHis);

        // 最後の1手前に戻る
        rootHis.removeLast();
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private void output(int result) {System.out.println(result);}
    }
}