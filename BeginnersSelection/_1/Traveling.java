import java.util.Scanner;

class Traveling {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[2], x = new int[2], y = new int[2];

        for (int i = 0; i < n; i++) {
            t[1] = sc.nextInt();
            x[1] = sc.nextInt();
            y[1] = sc.nextInt();

            // 時間内に到達不可能な場合、または時間ちょうどにマスにいる事が不可能な場合
            if (diff(x) + diff(y) > diff(t) || (diff(x) + diff(y) + diff(t)) % 2 == 1) {
                System.out.println("No");
                sc.close();
                return;
            } else {
                t[0] = t[1];
                x[0] = x[1];
                y[0] = y[1];
            }
        }
        sc.close();
        System.out.println("Yes");

    }

    private static int diff(int[] n) {
        return Math.abs(n[1] - n[0]);
    }
}