import java.util.Scanner;

public class Submask {
    public static void main(String[] args) {
        // この解法を理解したい
        // https://zenn.dev/dhirabayashi/articles/9f3da895f8d839
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();

        long x = 0;
        for (long i = 0; i <= n; i++) {
            System.out.println(x);
            if (x == n) break;

            x = (x - n) & n;
        }
    }
}