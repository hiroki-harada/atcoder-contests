import java.util.*;

public class SomeSums {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        int result = 0;
        for (int i = 1; i <= n; i++) {

            // もっと別の解法を考える
            // String の配列に変換
            // String -> Integer に変換して足し合わせる
            String[] s = String.valueOf(i).split("");
            int target = Arrays.asList(s).stream()
                    .map(str -> Integer.parseInt(str))
                    .reduce(0, (s1, s2) -> s1 + s2);

            if (target >= a && target <= b) result += i;
        }

        System.out.println(result);
    }
}