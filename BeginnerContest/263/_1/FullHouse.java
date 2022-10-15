import java.util.*;

public class FullHouse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = 5;
        List<Integer> list = new ArrayList<>();
        while (n-- > 0) list.add(sc.nextInt());
        sc.close();

        // カードの種類が2種類とそれ以外で場合分け

        // カードの種類が2種類で無い場合
        Set<Integer> set = new HashSet<>(list);
        if (set.size() != 2) {
            System.out.println("No");
            return;
        }

        // カードの種類が2種類の場合 同じカードが4枚の可能性もあるため注意
        // パターン1： 1 2 2 2 2
        // パターン2： 4 4 4 4 9
        LinkedList<Integer> linkedList = new LinkedList<>(list);

        // ソートした上で、最初と最後を取り除き、カードの種類が2種類ならフルハウス
        Collections.sort(linkedList);
        linkedList.removeFirst();
        linkedList.removeLast();
        Set<Integer> linkiedSet = new HashSet<>(linkedList);
        System.out.println(linkiedSet.size() == 2 ? "Yes" : "No");
    }
}