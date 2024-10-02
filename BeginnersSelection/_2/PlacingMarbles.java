import java.util.Arrays;
import java.util.Scanner;

public class PlacingMarbles {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] s = sc.next().split("");
        sc.close();
        int result = Arrays.asList(s).stream()
                .map(str -> Integer.parseInt(str))
                .reduce(0, (s1, s2) -> s1 + s2);

        System.out.println(result);
    }
}