import java.util.*;

public class CardGameForTwo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] a = new Integer[n + 1]; // n が奇数だった場合の小細工
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        a[n] = 0; // n が奇数だった場合の小細工

        a = Arrays.asList(a).stream().sorted((x, y) -> y - x).toArray(Integer[]::new);

        int alice = 0;
        int bob = 0;
        for (int i = 0; i < n; i = i + 2) {
            alice += a[i];
            bob   += a[i+1];
        }

        System.out.println(alice - bob);
    }
}