import java.util.*;

public class Influencer {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int m = io.nextInt();
        // 外側のリストサイズは固定なので、↓もスマート
        // ArrayList<Integer>[] g = new ArrayList[n + 1];
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int a = io.nextInt();
            int b = io.nextInt();
            g.get(a).add(b);
            g.get(b).add(a);
        }
        io.close();

        int numStudent = 0;
        int cntMaxFriendsNum = 0;
        for (int i = 1; i <= n; i++) {
            int cntIFriendsNum = g.get(i).size();
            if (cntIFriendsNum > cntMaxFriendsNum) {
                numStudent = i;
                cntMaxFriendsNum = cntIFriendsNum;
            }
        }
        io.output(numStudent);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private void output(int result) {System.out.println(result);}
    }
}