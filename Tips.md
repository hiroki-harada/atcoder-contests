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