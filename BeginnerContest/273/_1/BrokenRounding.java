import java.util.Scanner;

public class BrokenRounding {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        int k = sc.nextInt();
        sc.close();

        for (int i = 0; i < k; i++) {
            // 四捨五入したい位が、小数点第1位に来るようにする
            // roundで丸め、元の桁数に復元する
            double base = Math.pow(10.0, i + 1);
            double tmp = x / base;
            x = (long)Math.round(tmp);
            x *= base;
        }
        System.out.println(x);
    }
}