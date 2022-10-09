import java.util.*;

public class MaxEven {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 奇数と偶数で振り分け（ポイント！）
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (a%2 == 1) odd.add(a);
            else         even.add(a);
        }
        sc.close();

        // 降順でソート
        Collections.sort(odd, (x, y) -> y.compareTo(x));
        // odd.stream().forEach(System.out::print); System.out.println();
        Collections.sort(even, (x, y) -> y.compareTo(x));
        // even.stream().forEach(System.out::print); System.out.println();

        // 偶数が1個以下の場合や奇数が1個以下の場合は、和で偶数を作れないため除外
        int result = -1;
        if (odd.size() >= 2)  result = Math.max(result, odd.get(0)  + odd.get(1));
        if (even.size() >= 2) result = Math.max(result, even.get(0) + even.get(1));
        System.out.println(result);
    }
}