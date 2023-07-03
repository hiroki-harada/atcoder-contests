import java.util.*;

public class Dash {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int m = io.nextInt();
        int h = io.nextInt();
        int k = io.nextInt();
        String s = io.nextStr();

        // hasItems[i, [j, boolean]] := (i, j) にアイテムが存在するかどうか
        Map<Integer, Map<Integer, Boolean>> hasItems = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int xi = io.nextInt();
            int yi = io.nextInt();

            Map<Integer, Boolean> map = hasItems.get(xi);
            if (null == map) map = new HashMap<>();
            map.put(yi, true);
            hasItems.put(xi, map);
        }
        io.close();

        String result = "Yes";
        int xt = 0, yt = 0;
        for (int i = 0; i < n; i++) {
            // 体力消費
            if (--h < 0) {
                result = "No";
                break;
            }

            // 移動先決定
            char si = s.charAt(i);
            if (si == 'R') xt++;
            if (si == 'L') xt--;
            if (si == 'U') yt++;
            if (si == 'D') yt--;

            // アイテムがあれば消費
            if (h >= k) continue;
            if (null == hasItems.get(xt) || !hasItems.get(xt).containsKey(yt) || !hasItems.get(xt).get(yt)) continue;

            h = k;
            hasItems.get(xt).put(yt, false);
        }

        io.output(result);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
        private <T> void output(T result) {System.out.println(result);}
    }
}