import java.util.*;

public class BuyOneCartonOfMilk {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        int s = in.nextInt();
        int m = in.nextInt();
        int l = in.nextInt();
        in.close();

        // 購入個数パック数が100を超える最初のindexまで、適当な回数ループさせる
        int result = Integer.MAX_VALUE;
        for (int i = 0; i*6 < 100+6; i++) {
            for (int j = 0; j*8 < 100+8; j++) {
                for (int k = 0; k*12 < 100+12; k++) {
                    if (i*6 + j*8 + k*12 < n) continue;
                    result = Math.min(result, s*i + m*j + l*k);
                }
            }
        }

        System.out.println(result);
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
    }
}