import java.util.Scanner;

public class ShiftOnly {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt(); 
        sc.close();

        int result = 0;
        while (true) {

            // 全ての要素に対して、2で割った結果を足し合わせる
            int temp = 0;
            for (int i = 0; i < n; i++) {
                temp += a[i]%2;
            }

            // 全要素の中に奇数が含まれる場合、前回のループ結果を出力
            if (temp != 0) {
                System.out.println(result);
                return;
            }

            // 全要素が偶数の場合、各要素を2で割った値に置き換える
            for (int i = 0; i < n; i++) {
                a[i] /= 2;
            }
            // 結果を更新する
            result++;
        }

    }
}