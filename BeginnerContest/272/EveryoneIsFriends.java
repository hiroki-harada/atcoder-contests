import java.util.Scanner;

public class EveryoneIsFriends {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[][] x = new boolean[n + 1][];

        for (int i = 0; i < m; i++) {
            int k = sc.nextInt();
            for (int j = 1; j <= n; j++) {
                x[j] = new boolean[k];
            }

            for (int j = 0; j < k; j++) {
                x[sc.nextInt()][i] = true;
            }
        }
        sc.close();
tatus

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                for (int k = 0; k < m; k++) {
                    if (!x[i][k] && !x[j][k]) {
                        System.out.println("No");
                        return;
                    }
                }
            }
        }
        System.out.println("Yes");
    }
}