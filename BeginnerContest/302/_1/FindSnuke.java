import java.util.*;

public class FindSnuke {

    static List<Integer> result;
    static char[] UKE = new char[] {'n','u','k','e'};
    static int h;
    static int w;
    static String[] s;

    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        h = io.nextInt();
        w = io.nextInt();
        s = io.nextStrArray(h);
        io.close();

        int[] dx = {-1 ,-1 ,-1 ,0 , 0, 1, 1, 1};
        int[] dy = {-1 , 0, 1, -1, 1, -1, 0, 1};

        // 任意のマス (i, j) を指定
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {

                // (i, j) からの方向(8方位)を指定
                for (int k = 0; k < 8; k++) {
                    String snuke = "";

                    // (i, j)　を起点に、5マスの文字を連結
                    for (int t = 0; t < 5; t++) {
                        int xi = i + t*dx[k];
                        int yi = j + t*dy[k];
                        if (xi < 0 || xi >= h || yi < 0 || yi >= w) break;
                        snuke += s[xi].charAt(yi);
                    }

                    // 答えの文字列が生成できなかったら、再び生成し直し
                    if (!snuke.equals("snuke")) continue;

                    StringBuilder result = new StringBuilder();
                    for (int t = 0; t < 5; t++) {
                        int x = i + t*dx[k] + 1;
                        int y = j + t*dy[k] + 1;
                        result.append(x).append(" ").append(y);
                        if (t < 4) result.append("\r\n");
                    }
                    io.output(result.toString());
                    return;
                }
            }
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