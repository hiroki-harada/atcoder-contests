import java.util.*;

public class SameMapInTheRPGWorld {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int h = io.nextInt();
        int w = io.nextInt();
        String[] a = io.nextStrArray(h);
        String[] b = io.nextStrArray(h);
        io.close();

        // 0 <= s < H, 0 <= h < W であるs, t に対して
        // 縦方向のシフトをs 回、次に横方向のシフトをt 回行った時
        // 操作後の各A、B が一致するか判定
        for (int s = 0; s < h; s++) {
            for (int t = 0; t < w; t++) {

                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {

                        if (a[(i-s+h)%h].charAt((j-t+w)%w) != b[i].charAt(j)) {
                            io.output("No");
                            return;
                        }
                    }
                }
            }
        }

        io.output("No");
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