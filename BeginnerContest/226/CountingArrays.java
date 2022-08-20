import java.util.*;
class CountingArrays {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Set<String> ans = new HashSet<String>();
        for (int j = 0; j < N; j++) {
            ans.add(sc.nextLine());
       }
        sc.close();
        System.out.println(ans.size());
    }
}