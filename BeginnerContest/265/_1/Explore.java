import java.util.*;

public class Explore {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        int  m = sc.nextInt();
        // 1 ≤ Yi ≤ 10^9 のため、持ち時間 T が intだと桁あふれする可能性がある
        long t = sc.nextLong();

        int[] a = new int[n];
        for (int i = 1; i <= n - 1; i++) {
            a[i] = sc.nextInt();
        }

        Map<Integer, Integer> bonus = new HashMap<>();
        for (int i = 0; i < m; i++) {
            // Map(xi, yi)
            bonus.put(sc.nextInt(), sc.nextInt());
        }
        sc.close();


        // 部屋1~n まで移動する間に、持ち時間が 0 以下になれば移動不可と判定する
        for (int iRoom = 1; iRoom <= n - 1; iRoom++) {
            // ボーナス部屋に到達した場合、持ち時間を増やす
            if (bonus.containsKey(iRoom)) {
                t += bonus.get(iRoom);
                // System.out.println("持ち時間が " + bonus.get(iRoom+1) + " 増え " + t + " になった！");
            }

            // 持ち時間を消費して、移動
            t -= a[iRoom];
            // System.out.println("持ち時間を " + a[iRoom] + " 消費して部屋 " + (iRoom+1) + " に移動");
            // System.out.println("持ち時間は " + t + " になった");

            // 持ち時間が 0 以下なら、操作終了
            if (t <= 0) {
                // System.out.println("持ち時間が " + t + " になってしまった。。。");
                System.out.println("No");
                return;
            }

        }
        System.out.println("Yes");
    }
}