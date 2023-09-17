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
