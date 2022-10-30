import java.util.Scanner;

public class FindTakahashi {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int iHightest = 0;
        int maxH = 0;
        for (int i = 1; i <= n; i++) {
            int hi = sc.nextInt();
            if (hi > maxH) {
                iHightest = i;
                maxH = hi;
            }
        }
        sc.close();

        System.out.println(iHightest);
    }
}