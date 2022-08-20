import java.util.*;
// 参考
// https://qiita.com/5zm/items/949bf0721e8324f0ee35
class Triangle {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        for (int i=0; i<N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        sc.close();

        int ans = 0;
        // 点の選び方は、nC3 = n*(n-1)*(n-2)/3 通り
        for (int i=0; i<N-2; i++) {
            for (int j =i+1; j<N-1; j++) {
                for (int k=j+1; k<N; k++) {

                    // (x[i], [y[i]) を起点とするベクトルを求める
                    int[] vec1 = {x[j]-x[i], y[j]-y[i]};
                    int[] vec2 = {x[k]-x[i], y[k]-y[i]};

                    // 内積 != 0 をカウントする
                    if (vec1[0]*vec2[1] - vec1[1]*vec2[0] != 0) ans++;
                }
            }
        }

        System.out.println(ans);
    }
}