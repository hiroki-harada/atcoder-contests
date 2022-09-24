import java.util.Scanner;

public class MinMaxPair {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        
        long ans = 0;

        // ai = i && aj = j のパターン
        // - ak = k (k include i, j) となる k を数え上げる
        // - k の個数を n として、上記パターンを満たす総数は、
        // 異なる n 個の数から、2つを選ぶパターン数と同じになるので、nC2 = n(n-1)/2
        for (int i = 1; i <= n; i++) {
            if (a[i] == i) ans++;            
        }
        ans = ans * (ans - 1) / 2;
        
        // aj = i && ai = j のパターン
        // 前者を満たせば、(i, j)の組み合わせが自動的に決まるので、nC2 のような操作は不要
        // a[i] > i の意味は？ ai != i の代わり？
        for (int i = 1; i <= n; i++) {
            if (a[i] > i && a[a[i]] == i) ans++;
        }

        System.out.println(ans);

    }
}