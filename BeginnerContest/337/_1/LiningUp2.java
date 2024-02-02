import java.util.*;

public class LiningUp2 {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        Map<Integer, Integer> mapLiners = new HashMap<>();
        for (int i = 1; i <= n; i++) mapLiners.put(in.nextInt(), i);
        in.close();

        int previousKey = -1;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int iVal = mapLiners.get(previousKey);
            result.append(iVal).append(" ");

            previousKey = iVal;
        }

        System.out.println(result.toString().trim());
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
    }
}