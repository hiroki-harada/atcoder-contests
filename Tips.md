# 競プロの心得

## 困ったときの発想転換
* 最終手から考える
* 文字列の削除 -> 文字列の作成　に置き換える

## 組み合わせ最適化
下に行くほど、パフォーマンスが良く、実装難易度が高い？

* 全探索(要素の数分ループ)
  * (各要素*要素の桁数) * 桁数 <= 10^9 くらいならオススメ

* 全探索(bitなど)


* 2分探索

## 入力値の読み取り
* 下記のケースを混同していないか
```bash
// 数列が与えられる
A1 A2 ... An-1 An
B1 B2 ... Bn-1 Bn

// ペアが与えられる
A1 B1
A2 B2
...
An-1 Bn-1
An Bn
```


# 数学

## ⌈x⌉ (x以上の最小の整数)
```java
// k := ⌈N/D⌉
int k = (n+d-1)/d;
```



# Javaの記法
## 適当な参照クラスをvalue に取るMap、にvalueを設定する
```java
Map<T, List<U>> map = new HashMap<>();
map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
```


## 累乗
```java
/*
 * base ^ exp を返す
 * ※Math.pow() は大きな値を精度良く計算できないため、自作
 */
private static long pow(long base, long exp) {
    long result = 1;
    for (int i = 0; i < exp; i++) result *= base;
    return result;
}
```

## n進数
```java
// reference(Integer に限定)
// https://docs.oracle.com/javase/jp/17/docs/api/java.base/java/lang/Integer.html

/**
 * n進数表記
 */
// 文字列str を、n進数i_n として定義
int i_n = Integer.parseInt(str, n);

// parseInt("0", 10) returns 0
// parseInt("+42", 10) returns 42
// parseInt("99", 8) throws a NumberFormatException
// parseInt("Kona", 10) throws a NumberFormatException
// parseInt("Kona", 27) returns 411787


/**
 * n進数変換
 */
// 10進数i_10 -> 2,8,16進数
String i_2 = Integer.toBinaryString(i_10);
String i_8 = Integer.toOctalString(i_10);
String i_16 = Integer.toHexString(i_10);

// 10進数i_m -> n進数i_n
int i_n = Integer.parseInt(Integer.toString(i_m, n));
```


## 文字列中の最長回文判定
```java
// reference
// https://atcoder.jp/contests/abc320/tasks/abc320_c
public static void main(String[] args) {

    IOHandler io = new IOHandler();
    String s = io.nextStr();
    io.close();

    int maxLength = 1; // 最小の回文の長さは1
    // 各文字を中心とする回文を全パターン考える
    for (int i = 0, len = s.length(); i < len; i++) {
        // 奇数長の回文
        int oddLength = expandAroundCenter(s, i, i);
        maxLength = Math.max(maxLength, oddLength);

        // 偶数長の回文
        int evenLength = expandAroundCenter(s, i, i + 1);
        maxLength = Math.max(maxLength, evenLength);
    }

    io.output(maxLength);
}

// 左右に最大限拡張した場合の、回文の長さを返す
private static int expandAroundCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
    }
    return right - left - 1;
}
```

## Input(高速版)
```java
import java.io.*;
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    // N M
    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    // A1, A2, ..., Am
    st = new StringTokenizer(br.readLine());
    int[] a = new int[m];
    for (int i = 0; i < m; i++) {
        a[i] = Integer.parseInt(st.nextToken());
    }
}
```


# テキスト処理
## 0埋め
```java
/*
 * 指定したsizeまで、0を左詰めする
*/
private static String zeroPadding(String base, int size) {
    if (base.length() >= size) return base;

    StringBuilder sb = new StringBuilder();
    for (int i = base.length(); i < size; i++) sb.append("0");
    return sb.append(base).toString();
}
```

## 順列
```java
// 計算量: O(N!)
private static boolean nextPermutation(String[] array) {
    // 配列を右から走査して、文字入替の最左点を探す
    int left = array.length - 2;
    while (left >= 0 && array[left].compareTo(array[left+1]) >= 0)  left--;
    // 最後の組み合わせだった場合
    if (left < 0) return false;

    // 配列を右から走査して、文字入替の最右点を探す
    int right = array.length - 1;
    while (array[right].compareTo(array[left]) <= 0) right--;

    // 両端の文字を入れ替える
    swap(array, left, right);
    // 最左点より右の文字列を逆順にする  ex) acbd -> dbca
    reverse(array, left+1, array.length-1);
    return true;
}

private static void swap(String[] array, int i, int j) {
    String temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}

private static void reverse(String[] array, int i, int j) {
    while (i < j) {
        swap(array, i, j);
        i++;
        j--;
    }
}
```



# アルゴリズム
## Union Find
```java
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
    public int calcSizeOfRoot(int x) {
        return size[root(x)];
    }

    /*
    * 点 u, v が同じ木に属するか判定
    */
    private boolean same(int u, int v) {
        if (root(u) == root(v)) return true;
        return false;
    }

    /*
    * 点 u の根を返す
    * 再帰呼び出しの方が while (true) より速かった、理由は不明
    */
    private int root(int x) {
        if (parent[x] == -1) return x;
        return parent[x] = root(parent[x]);
    }
}
```
