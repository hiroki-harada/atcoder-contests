import java.util.*;

public class Same {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        Set<Integer> a = new HashSet<>();
        while (n-- > 0) a.add(in.nextInt());
        in.close();

        System.out.println(a.size() == 1 ? "Yes" : "No");
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
    }
}