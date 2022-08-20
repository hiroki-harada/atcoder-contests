import java.util.*;
class CardGameForTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        sc.close();

        Arrays.sort(a);

        int r = 0;
        for (int i = 1; i <= n; i++) {
            if (i%2 == 1) r += a[n - i];
            else r -= a[n - i];
        }
        System.out.println(r);
    }
}