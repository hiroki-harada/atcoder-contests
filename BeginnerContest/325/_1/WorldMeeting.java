import java.util.*;

public class WorldMeeting {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        int[] w = new int[n];
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
            x[i] = in.nextInt();
        }
        in.close();

        int result = 0;

        // 世界標準時の0-23時それぞれで、参加可能人数をチェック
        for (int time = 0; time < 24; time++) {
            int particitants = 0;
            for (int i = 0; i < n; i++) {
                // 拠点i の営業時間に含まれる場合
                if (9 <= (x[i]+time)%24 && (x[i]+time)%24 < 18) particitants += w[i];
            }

            result = Math.max(result, particitants);
        }

        System.out.println(result);
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
    }
}