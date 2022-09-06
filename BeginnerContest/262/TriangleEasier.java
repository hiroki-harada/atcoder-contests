import java.util.Scanner;

public class TriangleEasier {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        if (n > m) {
            System.out.println(0);
            sc.close();
            return;
        }

        boolean[][] uv = new boolean[n + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            uv[u][v] = uv[v][u] = true;
        }
        sc.close();

        int ans = 0;
        for (int i = 1; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (uv[i][j] && uv[j][k] && uv[k][i]) ans++;
                }
            }
        }

        System.out.println(ans);
    }
}