import java.util.Scanner;

public class Traveling {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // i-1, i 回目の計算結果を保持する
        int[] t = new int[2];
        int[] x = new int[2];
        int[] y = new int[2];
        for (int i = 0; i < n; i++) {
            t[1] = sc.nextInt();
            x[1] = sc.nextInt();
            y[1] = sc.nextInt();

            int dx = Math.abs(x[1] - x[0]);
            int dy = Math.abs(y[1] - y[0]);
            int dt = Math.abs(t[1] - t[0]);

            // 時間内に到達不可能な場合が一度でもあれば No
            // 到達可能でも、ちょうどの時間で止まれない(周辺のマスを徘徊して時間をつぶす)場合も No
            int currentStep = dx + dy - dt;
            // 負数の場合は、余り-1 になるため注意
            if (currentStep > 0 || Math.abs(currentStep%2) == 1) {
                System.out.println("No");
                sc.close();
                return;
            }

            t[0] = t[1];
            x[0] = x[1];
            y[0] = y[1];
        }

        // 全てのパターンで時間内に到達可能だった場合
        System.out.println("Yes");
        sc.close();
    }
}