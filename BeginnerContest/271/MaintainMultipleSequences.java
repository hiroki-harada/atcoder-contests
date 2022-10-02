import java.util.Scanner;

public class MaintainMultipleSequences {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[][] a = new int[n+1][];
        for (int i = 1; i <= n; i++) {
            int l = sc.nextInt();
            a[i] = new int[l+1];
            for (int j = 1; j <= l; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= q; i++) {
            int s = sc.nextInt();   
            int t = sc.nextInt();   
            System.out.println(a[s][t]);
        }

        sc.close();

    }
}