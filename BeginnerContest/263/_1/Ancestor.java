import java.util.Scanner;

public class Ancestor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n + 2];
        for (int i = 2; i <= n; i++) {
            p[i] = sc.nextInt();
        }
        sc.close();

        int result = 0;
        int i = n;
        while (true) {
            i = p[i];
            result++;
            if (i == 1) {
                System.out.println(result);
                return;
            }
        }
    }
}