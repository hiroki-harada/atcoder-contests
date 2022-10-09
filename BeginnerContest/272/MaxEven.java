import java.util.Scanner;

public class MaxEven {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }


        // // n = 2 の場合だけ特殊パターンとしてロジック用意
        // if (n == 2) {
        //     int a1 = sc.nextInt();
        //     int a2 = sc.nextInt();
        //     System.out.println((a1 + a2)%2 == 1 ? -1 : a1 + a2);
        // }

        // // n =< 3
        // int result = 0;
        // int previous = 0;
        // for (int i = 0; i < n; i++) {
        //     int current = sc.nextInt();

        //     int temp = result - previous + current;
        //     if (temp%2 == 0) result = Math.max(result, temp);
        //     previous = current;
        // }
        // sc.close();

    }
}