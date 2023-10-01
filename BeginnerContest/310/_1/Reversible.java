import java.util.*;

public class Reversible {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        String[] s = io.nextStrArray(n);
        io.close();

        Set<String> result = new HashSet<>();
        for (int i = 0; i < n; i++) {
            // そのまま設定
            result.add(s[i]);

            var reverse = (new StringBuilder(s[i])).reverse().toString();
            if (reverse.equals(s[i])) continue;

            // 前後を入れ替えて設定した文字が既に存在するとき、追加した文字を除外
            if (!result.add(reverse)) result.remove(s[i]);
            // 存在しないときは、前後を入れ替えた文字を除外
            else result.remove(reverse);
        }
        io.output(result.size());
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
        private void output(int result) {System.out.println(result);}
    }
}