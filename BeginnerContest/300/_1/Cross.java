import java.util.*;

public class Cross {
    static int h;
    static int w;
    static String[] c;

    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        h = io.nextInt();
        w = io.nextInt();
        c = io.nextStrArray(h);
        io.close();


        int[] s = new int[Math.min(h, w)+1];

        for (int i = 1; i < h-1; i++) {
            for (int j = 1; j < w-1; j++) {

                // 中心点を決める
                if (c[i].charAt(j) == '.') continue;

                // 中心点の周辺を探索して、x の大きさを見積もる
                if (hasEdge(i, j, 1)) {
                    int d = 1;

                    while (isInArea(i, j, d+1) && hasEdge(i, j, d+1)) d++;
                    s[d]++;
                }
            }
        }

        io.outputIntArray(s, 1, s.length, " ");
    }

    private static boolean isInArea(int x, int y, int d) {
        if (x-d < 0 || x+d >= h) return false;
        if (y-d < 0 || y+d >= w) return false;
        return true;
    }

    private static boolean hasEdge(int x, int y, int d) {
        if (c[x+d].charAt(y+d) == '.') return false;
        if (c[x+d].charAt(y-d) == '.') return false;
        if (c[x-d].charAt(y-d) == '.') return false;
        if (c[x-d].charAt(y+d) == '.') return false;
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
        private void outputIntArray(int[] array, int start, int end, String delimiter) {
            StringBuilder result = new StringBuilder();
            for (int i = start; i < end; i++)  result.append(array[i]).append(delimiter);
            System.out.println(result.toString().substring(0, result.length()-delimiter.length()));
        }
    }
}