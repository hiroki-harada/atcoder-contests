import java.util.*;

public class BadJuice {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        int m = 1;
        while (Math.pow(2, m) < n) m++;
        System.out.println(m);

        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            // 2進法でジュースを割り当てる？
            for (int j = 0; j < n; j++) {
                if ((j >> i & 1) == 1) list.add(j + 1);
            }

            // 本数を出力
            System.out.print(list.size());

            // ジュースの番号を出力
            StringBuilder sb = new StringBuilder();
            for (Integer el : list) sb.append(" ").append(el);
            System.out.println(sb.toString());
        }

        String s = in.nextStr();
        in.close();

        int result = 1;
        for (int i = 0; i < s.length(); i++) {
            // 何してるか分からん
            if (s.charAt(i) == '1') result += 1<<i;
        }

        System.out.println(result);
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
    }
}