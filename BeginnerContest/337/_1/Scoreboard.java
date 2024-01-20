import java.util.*;

public class Scoreboard {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();

        int scoreAoki = 0;
        int scoreTakahashi = 0;
        for (int i = 0; i < n; i++) {
            scoreTakahashi += in.nextInt();
            scoreAoki += in.nextInt();
        }
        in.close();

        System.out.println(scoreTakahashi > scoreAoki ? "Takahashi" : scoreTakahashi < scoreAoki ? "Aoki" : "Draw");
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
    }
}