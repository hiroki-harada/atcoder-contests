import java.util.Scanner;
import java.util.HashSet;

public class FiveIntegers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i < 5; i++) {
            hs.add(sc.nextInt());
        }
        sc.close();

        System.out.println(hs.size());
    }
}