import java.util.*;

public class FF {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int q = io.nextInt();
        // List<Set<Integer>> で保持すると、処理に時間がかかる
        // n*a+b をキーにすることで、Listとして保持せずに重複回避できる
        Set<Integer> isfollowing = new HashSet<Integer>();

        for (int i = 0; i < q; i++) {
            int t = io.nextInt();
            int a = io.nextInt();
            int b = io.nextInt();

            switch (t) {
                case 1:
                    isfollowing.add(n*a + b);
                    break;
                case 2:
                    isfollowing.remove(n*a + b);
                    break;
                case 3:
                    if (isfollowing.contains(n*a + b) && isfollowing.contains(n*b + a)) {
                        io.output("Yes");
                    } else {
                        io.output("No");
                    }
                    break;
            }
        }
        io.close();
    }


    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private int nextInt() {return this.sc.nextInt();}

        private <T> void output(T result) {System.out.println(result);}
    }
}