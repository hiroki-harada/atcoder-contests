import java.util.Scanner;
import java.util.stream.*;
import java.util.Arrays;
import java.util.List;

class ShiftOnly {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Integer[] input = new Integer[n];
        for (int i = 0; i < n; i++) input[i] = sc.nextInt();
        sc.close();

        int ans = 0;
        List<Integer> listInput = Arrays.asList(input);
        while (true) {
            listInput = listInput.stream()
                    .filter(pmt -> pmt%2 == 0)
                    .map(pmt -> pmt/2)
                    .collect(Collectors.toList());
            if (n != listInput.size()) break;
            ans++;
        }

        System.out.println(ans);
    }
}