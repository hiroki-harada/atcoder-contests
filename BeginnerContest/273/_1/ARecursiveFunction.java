import java.util.Scanner;

public class ARecursiveFunction {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        System.out.println(func(n));
    }

    private static int func(int k) {
        if (k == 0) return 1;
        return k * func(k - 1);
    }
}