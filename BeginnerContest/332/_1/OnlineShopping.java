import java.util.*;

public class OnlineShopping {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        int s = in.nextInt();
        int k = in.nextInt();
        int[] p = new int[n];
        int[] q = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = in.nextInt();
            q[i] = in.nextInt();
        }
        in.close();

        int result = 0;
        for (int i = 0; i < n; i++) result += p[i]*q[i];
        if (result < s) result += k;

        System.out.println(result);
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
    }
}