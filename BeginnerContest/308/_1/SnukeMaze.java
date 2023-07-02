import java.util.*;

public class SnukeMaze {
    static int h;
    static int w;

    static String[] s;
    static boolean[][] isVisited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static Map<Character, Character> next = Map.of(
        's', 'n',
        'n', 'u',
        'u', 'k',
        'k', 'e',
        'e', 's'
    );

    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        h = io.nextInt();
        w = io.nextInt();
        s = io.nextStrArray(h);
        io.close();

        // スタートが s でないなら処理終了
        if (s[0].charAt(0) != 's') {
            io.output("No");
            return;
        }

        isVisited = new boolean[h][w];

        dfs(0, 0);

        io.output(isVisited[h - 1][w - 1] ? "Yes" : "No");
    }

    private static void dfs(int i, int j) {
        isVisited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            if (ni < 0 || ni >= h || nj < 0 || nj >= w) continue;
            if (s[ni].charAt(nj) != next.get(s[i].charAt(j))) continue;
            if (isVisited[ni][nj]) continue;

            dfs(ni, nj);
        }
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
        private <T> void output(T result) {System.out.println(result);}
    }
}