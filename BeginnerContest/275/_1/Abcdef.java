import java.util.Scanner;

public class Abcdef {
    public static void main(String[] args) {

        long divisor = 998244353;

        Scanner sc = new Scanner(System.in);
        // オーバーフローを考慮して、予め除算で処理する
        long a = mod(sc.nextLong(), divisor);
        long b = mod(sc.nextLong(), divisor);
        long c = mod(sc.nextLong(), divisor);
        long d = mod(sc.nextLong(), divisor);
        long e = mod(sc.nextLong(), divisor);
        long f = mod(sc.nextLong(), divisor);
        sc.close();

        // オーバーフローを考慮して、計算の都度modを取る
        long abc = mod(mod(a*b, divisor) * c, divisor);
        long def = mod(mod(d*e, divisor) * f, divisor);

        System.out.println(mod(abc - def, divisor));
    }

    /*
     * dividend % divisor を求める(負の数にも対応)
     */
    public static long mod(long dividend, long divisor) {
        return (Math.floorMod(dividend, divisor) + Math.abs(divisor)) % Math.abs(divisor);
    }
}