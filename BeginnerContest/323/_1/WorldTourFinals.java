import java.util.*;

public class WorldTourFinals {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = in.nextIntArray(m);
        String[] s = in.nextStrArray(n);
        in.close();

        List<Integer> currentScores = new ArrayList<>();
        // 現在の得点状況
        for (int player = 0; player < n; player++) {

            int score0 = 0;
            for (int i = 0; i < m; i++) {
                if (s[player].charAt(i) == 'o') score0 += a[i];
            }
            currentScores.add(score0+player+1);
        }

        int maxScore = Collections.max(currentScores);

        StringBuilder result = new StringBuilder();
        for (int player = 0; player < n; player++) {

            // まだ解いていない問題のみ取得
            List<Integer> additionalScores = createMaxNValues(a, s[player]);

            // 他のプレイヤー全員の現在の総合得点を上回ることができる、最少の問題数を求める
            for (int i = 0, size = additionalScores.size(); i < size; i++) {
                currentScores.set(player, currentScores.get(player) + additionalScores.get(i));
                if (currentScores.get(player) >= maxScore) {
                    result.append(i).append("\n");
                    break;
                }
            }
        }

        System.out.println(result.toString());
    }

    /*
     * 得点状況si から、まだ解いていない問題の得点だけ抽出する
     */
    private static List<Integer> createMaxNValues(int[] a, String si) {

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < si.length(); i++) {
            if (si.charAt(i) == 'x') result.add(a[i]);
        }
        Collections.sort(result, (i, j) -> j.compareTo(i));
        result.add(0, 0);
        return result;
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private int[] nextIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) array[i] = this.sc.nextInt();
            return array;
        }
        private String[] nextStrArray(int size) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < size; i++) list.add(this.sc.next());
            return list.toArray(new String[size]);
        }
    }
}