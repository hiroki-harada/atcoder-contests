import java.util.Scanner;

public class AtcoderSubstr {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        sc.close();

        System.out.println("atcoder".substring(l - 1, r));
    }
}