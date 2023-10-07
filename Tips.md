# 数学

## ⌈x⌉ (x以上の最小の整数)
```java
// k := ⌈N/D⌉
int k = (n+d-1)/d;
```



# Java
## 適当な参照クラスをvalue に取るMap、にvalueを設定する
```java
Map<T, List<U>> map = new HashMap<>();
map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
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
int i_2 = Integer.toBinaryString(i_10);
int i_8 = Integer.toOctalString(i_10);
int i_16 = Integer.toHexString(i_10);

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