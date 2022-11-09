import java.util.*;

public class MonotonicallyIncreasing {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();

        dfs(new ArrayList<Integer>(), n, m);
    }

    private static void dfs(List<Integer> sequence, int n, int m) {
        int size = sequence.size();
        if (size == n) {
            String result = sequence.get(0) + "";
            for (int i = 1; i < size; i++) result += " " + sequence.get(i);
            System.out.println(result);
            return;
        }

        int maxInList = size == 0 ? 0 : sequence.get(size-1);
        for (int i = maxInList+1; i <= m; i++) {
            List<Integer> temp = new ArrayList<Integer>(sequence);
            temp.add(i);
            dfs(temp, n, m);
        }
    }

}

// import java.util.*;

// public class MonotonicallyIncreasing {
//   public static void main(String args[]) {
//     Scanner sc = new Scanner(System.in);
//     int n = sc.nextInt();
//     int m = sc.nextInt();
//     sc.close();

//     dfs(n, 1, m, "");
//   }

//   private static void dfs(int limit, int maxPrevious, int m, String result) {
//     if (limit == 0) {
//       System.out.println(result);
//       return;
//     }

//     for (int maxCurrent = maxPrevious; maxCurrent <= m; maxCurrent++) {
//         dfs(limit-1, maxCurrent+1, m, result + ' ' + maxCurrent);
//     }
//   }
// }