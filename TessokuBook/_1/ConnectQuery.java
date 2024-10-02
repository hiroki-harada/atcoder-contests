import java.util.*;

public class ConnectQuery {

    static int[] parent;
    static int[] sizeOfTree;

    private static final int NONE = -1;

    public static void main(String[] args) {


        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int q = io.nextInt();
        int[] query = new int[q];
        int[] u = new int[q];
        int[] v = new int[q];
        for (int i = 0; i < q; i++) {
            query[i] = io.nextInt();
            u[i] = io.nextInt();
            v[i] = io.nextInt();
        }
        io.close();

        parent = new int[n+1];
        sizeOfTree = new int[n+1];
        Arrays.fill(parent, NONE);
        Arrays.fill(sizeOfTree, 1);

        for (int i = 0; i < q; i++) {
            if (query[i] == 1) {
                unite(u[i], v[i]);
            }
            if (query[i] == 2) {
                io.output(root(u[i]) == root(v[i]) ? "Yes" : "No");
            }
        }
    }

    // 頂点x の根を返す
    static int root(int x) {
        while (parent[x] != NONE) x = parent[x];
        return x;
    }

    // 頂点u, v を統合する
    static void unite(int u, int v) {
        int rootOfU = root(u);
        int rootOfV = root(v);

        if (rootOfU == rootOfV) return;

        // u の方が頂点数が多い場合
        if (sizeOfTree[rootOfU] > sizeOfTree[rootOfV]) {
            parent[rootOfV] = rootOfU;
            sizeOfTree[rootOfU] += sizeOfTree[rootOfV];
        // v の方が頂点数が多い場合
        } else {
            parent[rootOfU] = rootOfV;
            sizeOfTree[rootOfV] += sizeOfTree[rootOfU];
        }
    }


    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private <T> void output(T result) {System.out.println(result);}
    }
}