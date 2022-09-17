import java.util.Scanner;

public class ChineseRestaurant {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        sc.close();

        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = (p[i] - i - 1 + n) % n;
            for (int j = 0; j < 3; j++) {
                cnt[(j + tmp) % n]++;
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, cnt[i]);
        }

        System.out.println(ans);
    }
}