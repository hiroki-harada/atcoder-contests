import java.util.Scanner;

public class ManyOperations {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();

        int f0 = 0;
        // ここが良く分からない
        int mask = (1 << 30) - 1;
        int f1 = mask;
        
        while (n-- > 0) {
            int t = sc.nextInt();
            int a = sc.nextInt();

            switch (t) {
                case 1:
                    f0 &= a;
                    f1 &= a;
                    break;
                case 2:
                    f0 |= a;
                    f1 |= a;
                    break;
                case 3:
                    f0 ^= a;
                    f1 ^= a;
                    break;
            };
            // ここも良く分からない
            c = (f1 & c) | (f0 & (c ^ mask));
            System.out.println(c);
        }
        sc.close();
    }
}