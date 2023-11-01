import java.util.*;

public class RoundRobinTournament {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        String[] s = in.nextStrArray(n);
        in.close();

        // 勝ち数の多いプレイヤーから順に探す
        StringBuilder result = new StringBuilder();
        for (int cntWin = n; cntWin >= 0; cntWin--) {
            for (int player = 0; player < n; player++) {
                int cnt = s[player].replaceAll("x", "").length();
                if (cnt == cntWin) result.append(player+1).append(" ");
            }
        }


        System.out.println(result.toString());
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String[] nextStrArray(int size) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < size; i++) list.add(this.sc.next());
            return list.toArray(new String[size]);
        }
    }
}