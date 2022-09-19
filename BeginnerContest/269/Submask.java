import java.util.Scanner;

public class Submask {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();

        System.out.println(0);
        if(n == 0) return;

        for (long i = 0; i <= n; i++) {
            long temp = i;
            long cnt = 0;
            long val = 1;
            while (temp != 0) {

                if ((temp & n) == n) {
                    val = val + (val << (int)(Math.pow(2.0, (double)cnt)));
                }
                temp >>>= 1;
                cnt++;
            }
            System.out.println(val & ((1 << (i + 1)) - 1));
        }
    }
}