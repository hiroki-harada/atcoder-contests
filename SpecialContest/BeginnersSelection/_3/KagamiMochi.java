import java.util.*;

public class KagamiMochi {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> d = new HashSet<>();
        for (int i = 0; i < n; i++) d.add(sc.nextInt());
        sc.close();

        System.out.println(d.size());
    }
}