import java.util.*;

class SomeSums {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), A = sc.nextInt(), B = sc.nextInt();
        sc.close();

        int ans = 0;
        // 1以上N以下の整数に対して処理を実行
        for (int i = 1; i <= N; i++) {

            // 各桁の総和を求める、1桁目から順番に足していく
            int sumEachDigits = 0;
            int rest = i;
            while(rest > 0) {
                sumEachDigits += rest%10;
                rest /=10;
            }

            if (sumEachDigits >= A && sumEachDigits <= B ) {
                ans += i;
            }
        }

        System.out.println(ans);
    }
}