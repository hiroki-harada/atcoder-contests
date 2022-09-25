import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int x = sc.nextInt();
        sc.close();

        // 可能なコインの組み合わせについて全探索
        int result = 0;
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                for (int k = 0; k <= c; k++) {
                    int total = 500 * i + 100 * j + 50 * k;
                    // 合計金額が x を超えた場合は、100円玉から数えなおし
                    if (total > x) break;
                    if (total == x) result++;
                }
            }
        }

        System.out.println(result);
    }
}