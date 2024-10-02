import java.util.Scanner;

public class Otoshidama {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int y = sc.nextInt();
        sc.close();

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n-i; j++) {
                int k = n - i - j;
                int total = 10000 * i + 5000 * j + 1000 * k;
                if (total == y) {
                    System.out.println(i + " " + j + " " + k);
                    return;
                }
            }
        }
        System.out.println("-1 -1 -1");
    }
}