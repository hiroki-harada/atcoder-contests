import java.util.Scanner;

class Coins2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // aは500円、bは100円、cは50円
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), x = sc.nextInt();
        sc.close();

        int ans = 0;
        for(int i = 0; i <= a; i++)
            for (int j =0; j <= b; j++)
                for (int k = 0; k <= c; k++)
                    if (i * 500 + j * 100 + k * 50 == x) ++ans;
        System.out.println(ans);

    }
}