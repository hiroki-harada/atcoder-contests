import java.util.Scanner;

public class Hammer {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        sc.close();

        // y を正の数になるように補正すると、場合分けし易い
        if (y < 0) {
            x *= -1;
            y *= -1;
            z *= -1;
        }

        if (x < y) {
            System.out.println(Math.abs(x));
        } else {
            if (z > y) {
                System.out.println(-1);
            } else {
                System.out.println(Math.abs(z) + Math.abs(x - z));
            }
        }
    }
}