import java.util.*;

public class EraseLeaves {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();

        /*
        * 解答方針
        * 1 を含まない木を作成し、その最大ノード数を全ノード数から引く
        */
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < n-1; i++) {
            int u = in.nextInt()-1;
            int v = in.nextInt()-1;

            // u < v のため、「u が頂点1 ではない」という条件のみで、u, vを結合してOK
            if (u != 0) unionFind.unite(u, v);
        }
        in.close();

        int max = 0;
        for (int i = 0; i < n; i++) max = Math.max(max, unionFind.getSize(i));

        System.out.println(n - max);
    }

    // FIXME 最大1割程度パフォーマンスが悪いので、別の方法に変更したい
    // とはいえ、try-with-resources でメインロジック全体をラップしたくない
    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
    }
}

class UnionFind {
    private int[] parent;
    private int[] size;

    UnionFind(int n) {
        parent = new int[n];
        Arrays.fill(parent, -1);
        size = new int[n];
        Arrays.fill(size, 1);
    }

    /*
    * 点 u, v を結合して同じ木にまとめる
    */
    public void unite(int u, int v) {
        int rootU = root(u);
        int rootV = root(v);

        if (rootU == rootV) return;

        // ノード数の小さいグループの親を、ノード数の大きいグループの根に結合
        // ノード数を更新
        if (size[u] > size[v]) {
            parent[rootV] = rootU;
            size[rootU] += size[rootV];
        } else {
            parent[rootU] = rootV;
            size[rootV] += size[rootU];
        }
    }

    /*
    * x の根の大きさを返す
    */
    public int getSize(int x) {
        return size[x];
    }

    /*
    * 点 u の根を返す
    */
    private int root(int x) {
        if (parent[x] == -1) return x;
        return parent[x] = root(parent[x]);
    }
}