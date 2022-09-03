import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class NewFolder {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<String, Integer> inputHistory = new HashMap<String, Integer>();
        for (int i = 0; i < n; i++) {
            String input = sc.next();

            int cntInput = 0;
            if (!inputHistory.containsKey(input)) {
                inputHistory.put(input, 1);
            } else {
                cntInput = inputHistory.get(input);
            }

            String output = input + (cntInput != 0 ? "(" + cntInput +")": ""); 
            System.out.println(output);

            inputHistory.put(input, ++cntInput);
        }
        sc.close();

    }
}