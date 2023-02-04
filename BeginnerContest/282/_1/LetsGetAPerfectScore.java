import java.util.*;

public class LetsGetAPerfectScore {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int m = io.nextInt();
        String[] s = io.nextArray(n);
        io.close();

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                boolean enableClear = true;
                for (int k = 0; k < m; k++) {
                    if (s[i].charAt(k) == 'x' && s[j].charAt(k) == 'x') {
                        enableClear = false;
                    }
                }
                if (enableClear) result++;
            }
        }
        io.output(result);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private int nextInt() {return this.sc.nextInt();}

        private String[] nextArray(int size) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < size; i++) list.add(this.sc.next());
            return list.toArray(new String[size]);
        }

        private void output(int result) {System.out.println(result);}
    }
}