import java.util.*;

public class LikeSeacher {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int k = io.nextInt();
        io.close();

        // bit全探査で、321-like Numberのリストを作成する
        List<Long> resultList = new ArrayList<>();
        // i = 2, 3, ..., 10^10-2, 10^10-1
        for (int i = 2; i < (1<<10); i++) {
            long likeNumber = 0;

            // 最上位の桁から決定
            for (int j = 9; j >= 0; j--) {
                // i = 2
                // i&(1<<j) = 0000000001&1000000000, 0000000001&0100000000, ..., 0000000001&0000000010, 0000000001&0000000001, 0000000001&0000000000
                // i = 3
                // i&(1<<j) = 0000000011&1000000000, 0000000011&0100000000, ..., 0000000011&0000000010, 0000000011&0000000001, 0000000011&0000000000
                if ((i&(1<<j)) != 0) {
                    // i = 2, j = 1
                    // i = 3, j = 2, 1
                    // i = 4, j = 4
                    // i = 5, j = 4, 1
                    // i = 6, j = 4, 2
                    // i = 7, j = 4, 2, 1
                    // i = 8, j = 8
                    // i = 9, j = 8, 1
                    likeNumber *= 10;
                    likeNumber += j;
                }
            }
            // 1, 21, 4, 41, 42, 421, 8, 81
            resultList.add(likeNumber);
        }

        Collections.sort(resultList);

        io.output(resultList.get(k-1));
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private void output(long result) {System.out.println(result);}
    }
}