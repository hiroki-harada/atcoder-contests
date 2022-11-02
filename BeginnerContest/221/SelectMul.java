import java.util.Arrays;
import java.util.Scanner;

public class SelectMul {
    public static void main(String[] args) {

        /*
         * 分離の仕方は最大で 9!×8=2903040 通り（分離後の 2 整数の順序を区別しない場合
         * そのためあり得る分離の仕方を全探索しても十分に実行時間制限に間に合います。
         */

        Scanner sc = new Scanner(System.in);
        char[] n = sc.next().toCharArray();
        Arrays.sort(n);
        sc.close();

        int result = 0;
        for (int i = 1; i < n.length; i++) {
            result = Math.max(result, i);
        }
        System.out.println(result);
    }
}