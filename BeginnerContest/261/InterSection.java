import java.util.Scanner;

public class InterSection {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int l1 = sc.nextInt();
        int r1 = sc.nextInt();
        int l2 = sc.nextInt();
        int r2 = sc.nextInt();
        sc.close();
        
        int ans = Math.max( 0, Math.min(r2, r1) - Math.max(l2, l1));

        System.out.println(ans);
    }
}