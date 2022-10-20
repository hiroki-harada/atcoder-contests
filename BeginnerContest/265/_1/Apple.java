import java.util.Scanner;

public class Apple {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int n = sc.nextInt();
        sc.close();

        int result = Integer.MAX_VALUE;

        for (int ix = 0; ix <= n; ix++) {
            for (int iy = 0; iy <= n/3; iy++) {
                if (ix + iy * 3 == n) result = Math.min(result, ix * x + iy * y);
            }
        }
        System.out.println(result);
    }
}