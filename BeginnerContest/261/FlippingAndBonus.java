import java.util.Scanner;

public class FlippingAndBonus {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] x = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
		}

        // ボーナス カウンタの添え字に対応するindexに、金額を格納する
        // c[c0] = 1, c[1] = 0, c[c1] = 5, ...
		int[] y = new int[n + 1];
		for (int i = 0; i < m; i++) {
			y[sc.nextInt()] = sc.nextInt();
		}
		sc.close();
 

        long[][] dump = new long[n + 1][n + 1];
        // i + 1 回目のコイントスで、表/裏が出た場合に
        // 0 ~ i 回目までの結果を計算し直して、最大値を更新し続ける
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
                // i = i0+1 の時、i0 回目までの結果と比較して、大きい方を保持する

                // i0+1 回目のコイントスで表が出た場合の最大値
				dump[i + 1][j + 1] = Math.max(dump[i + 1][j + 1], dump[i][j] + x[i] + y[j + 1]);
                // i0+1 回目のコイントスで裏が出た場合の最大値
				dump[i + 1][0] = Math.max(dump[i + 1][0], dump[i][j]);
			}
		}
 
		long ans = 0;
		for (int i = 0; i <= n; i++) {
			ans = Math.max(ans, dump[n][i]);
		}
		System.out.println(ans);
	}
}