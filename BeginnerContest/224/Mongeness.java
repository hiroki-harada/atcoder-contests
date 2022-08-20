import java.util.*;

class Mongeness {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt(), W = sc.nextInt();
        long[][] A = new long[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                A[i][j] = sc.nextLong();
            }
        }
        sc.close();

        for (int i = 0; i < H-1; i++) {
            for (int j = 0; j < W-1; j++) {

                if (A[i][j] + A[i+1][j+1] > A[i+1][j] + A[i][j+1]) {
                    System.out.println(A[i][j] +" "+ A[i+1][j+1] +" "+ A[i+1][j] +" "+ A[i][j+1]);
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");
    }
}