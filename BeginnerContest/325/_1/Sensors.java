import java.util.*;

public class Sensors {

    static int h;
    static int w;
    static char[][] s;
    static boolean[][] isVisited;

    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        h = in.nextInt();
        w = in.nextInt();
        s = new char[h][w];
        for (int i = 0; i < h; i++) {
            s[i] = in.nextStr().toCharArray();
        }
        in.close();

        int result = 0;
        isVisited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                // 範囲外アクセス対策
                if (i < 0 || i >= h || j < 0 || j >= w) continue;
                // チェック不要/チェック済マスを弾く
                if (s[i][j] =='.' || isVisited[i][j]) continue;
                dfs(i, j);
                result++;
            }
        }

        System.out.println(result);
    }

    private static void dfs(int x, int y) {
        // チェックしていないマスのみ確認
        if (isVisited[x][y]) return;
        isVisited[x][y] = true;

        // 上
        if (x > 0 && s[x-1][y] == '#') dfs(x-1, y);
        // 右斜上
        if (x > 0 && y < w-1 && s[x-1][y+1] == '#') dfs(x-1, y+1);
        // 右
        if (y < w-1 && s[x][y+1] == '#') dfs(x, y+1);
        // 右斜下
        if (x < h-1 && y < w-1 && s[x+1][y+1] == '#') dfs(x+1, y+1);
        // 下
        if (x < h-1 && s[x+1][y] == '#') dfs(x+1, y);
        // 左斜下
        if (x < h-1 && y > 0 && s[x+1][y-1] == '#') dfs(x+1, y-1);
        // 左
        if (y > 0 && s[x][y-1] == '#') dfs(x, y-1);
        // 左斜上
        if (x > 0 && y > 0 && s[x-1][y-1] == '#') dfs(x-1, y-1);
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
    }
}