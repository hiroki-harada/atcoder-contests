import java.util.Scanner;
import java.util.stream.*;
import java.util.Arrays;
import java.util.List;

class KagamiMochi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Integer[] mochis = new Integer[n];
        for (int i = 0; i < n; i++) mochis[i] = sc.nextInt();
        sc.close();

        List<Integer> cntSum = Arrays.asList(mochis)
                .stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(cntSum.size());
    }
}