import java.util.*;
public class Otoshidama {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        // 合計金額は、1000円単位で受け取る
        int Y =sc.nextInt()/1000;
        sc.close();

        // Y/10 は1万円札の枚数
        // 想定される1万円札が0, 1, 2, ..., i 枚 の場合の順番に、ありうる組み合わせを考える
        // ただし、1万円札の枚数は、合計金額を越えてはいけない
        for (int i = 0; i <= Y/10; i++) {

            // 想定される5千円札の枚数が0, 1, 2, ..., j 枚 の場合の順番に、ありうる組み合わせを考える
            // ただし、i + j が合計枚数のNを越えてはいけない
            for (int j = 0; i + j <= N; j++) {

                    if (i * 10 + j * 5 + (N - i - j) == Y) {
                        System.out.println(i + " " + j + " " + (N - i - j));
                        return;
                    }
            }
        }

        System.out.println("-1 -1 -1");
    }
}