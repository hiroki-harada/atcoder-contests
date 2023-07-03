import java.util.*;

public class SnukeTheCookiePicker {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int h = io.nextInt();
        int w = io.nextInt();
        String[] s = io.nextStrArray(h);
        io.close();

        // 求める答えを (x, y) とおく
        int x = 0, y = 0;

        // x を求める
        int cntSharpX = 500;
        for (int i = 0; i < h; i++) {
            int cnt = 0;
            for (int j = 0; j < w; j++) {
                if (s[i].charAt(j) == '#') cnt++;
            }
            if (cnt != 0 && cnt < cntSharpX) {
                x = i;
                cntSharpX = cnt;
            }
        }

        // y を求める
        // 特定した x の上下含めて3行のみ調べる
        int cntSharpY = 500;
        for (int j = 0; j < w; j++) {
            int cnt = 0;
            for (int i = Math.max(x-1, 0); i <= Math.min(x+1, h-1); i++) {
                if (s[i].charAt(j) == '#') cnt++;
            }
            if (cnt != 0 && cnt < cntSharpY) {
                y = j;
                cntSharpY = cnt;
            }
        }

        io.output((x+1) + " " + (y+1));
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