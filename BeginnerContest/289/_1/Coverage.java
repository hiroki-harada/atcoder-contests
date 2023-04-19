import java.util.*;

public class Coverage {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int m = io.nextInt();
        List<List<Integer>> s = new ArrayList<>();
        for (int i = 0; i < m; i++) s.add(new ArrayList<>());

        for (List<Integer> list : s) {
            int ci = io.nextInt();
            while (ci-- > 0) list.add(io.nextInt());
        }
        io.close();

        int result = 0;
        for (int i = 0; i < 1<<m; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < m; j++) {
                // i の j ビット目が 1 の場合
                if ((i>>j & 1) == 1) {
                    // 集合Sj の中身を全て取得
                    for (Integer integer : s.get(j)) set.add(integer);
                }
            }
            if (set.size() == n) result++;
        }
        io.output(result);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private void output(int result) {System.out.println(result);}
    }
}