import java.util.*;

public class AdjacencyList {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<ArrayList<Integer>> cities = new ArrayList<>();
        for (int i = 0; i <= n; i++) cities.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            cities.get(a).add(b);
            cities.get(b).add(a);
        }
        sc.close();

        for (int i = 1; i <= n; i++) {
            List<Integer> result = cities.get(i);
            Collections.sort(result);
            System.out.print(result.size() + " ");
            for (Integer di : result) System.out.print(di + " ");
            System.out.print("\n");
        }
    }
}