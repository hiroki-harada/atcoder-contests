import java.util.*;

public class Append {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int q = in.nextInt();

        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int op = in.nextInt();
            int param = in.nextInt();

            if (op == 1) a.add(param);
            else System.out.println(a.get(a.size() - param));
        }
        in.close();
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
    }
}