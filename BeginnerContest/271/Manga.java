import java.util.*;

public class Manga {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 重複を削除しなかった場合、下記のようなパターンに対して 2 を出力することになる(正解は3)
        // n:4  a:1, 1, 2, 2
        // -> Set で入力値を受け取って重複を削除する
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) set.add(sc.nextInt());
        sc.close();
        
        // ->リストの最初と最後に対して操作をするためにLinkedListに詰め直す
        LinkedList<Integer> a = new LinkedList<>(set);
        Collections.sort(a);
        // 数合わせの為に、a.size() == n になるようダミー値を設定する(-1で有れば巻数と見做されることはない)
        while (a.size() != n) a.add(-1);


        // 巻数の計算開始
        for (int current = 1; current <= n; current++) {
            // 現在の巻数を所持している場合は、取り除く
            if (a.size() != 0 && a.getFirst() == current) {
                a.removeFirst();
                // System.out.println(i + " is read");
            }
            // 現在の巻数を所持していない場合
            // 現在所持している巻数の大きい方(含ダミー)から売る
            else if (a.size() >= 2) {
                a.removeLast();
                a.removeLast();
            }
            // 2冊以上売れない場合、直前の巻数を出力して処理終了
            else {
                System.out.println(current - 1);
                // System.out.println("books cannot be sold");
                return;
            }

            // todo: この処理があると、なぜかAC になる
            if (a.size() == 0) {
                System.out.println(current);
                return;
            }
        }
    }
}