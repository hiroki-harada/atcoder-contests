import java.util.Scanner;

public class Ameba {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        /* 公式解答を元に実装 */
        // 求める答えは親のアメーバに対する答え +1 になります。 = +1 する -> 1世代遡る
        // したがって、各アメーバが生まれたタイミングで答えを記録することで、O(N) で解くことができます。
        int[] result = new int[2*n +1];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            result[2*i + 1] = result[a - 1] + 1;
            result[2*i + 2] = result[a - 1] + 1;
        }
        sc.close();

        for (int ans : result) System.out.println(ans);
    }
}