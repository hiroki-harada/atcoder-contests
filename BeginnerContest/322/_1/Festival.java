import java.io.*;
import java.util.*;

public class Festival {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        // 花火が上がる日：1, 花火が上がらない日：0
        int[] aryFireWorksDays = new int[n];
        for (int aa : a) aryFireWorksDays[aa-1] = 1;

        // 最終日から順に求めることで、下記のような部分的に昇順な数列として算出できる(O(N))
        // 0, 1, 2, 3, 0, 1, 2, 0, ...
        String[] result = new String[n];
        int offsetDays = 0;
        for (int i = n-1; i >= 0; i--) {
            if (aryFireWorksDays[i] == 1) {
                result[i] = "0";
                offsetDays = 0;
            } else {
                result[i] = String.valueOf(++offsetDays);
            }
        }

        System.out.println(String.join("\n", result));
    }
}