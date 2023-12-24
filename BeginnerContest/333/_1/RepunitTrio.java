import java.util.*;

public class RepunitTrio {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        in.close();

        // 13 桁以上の考慮は不要のため、13桁未満の範囲のレピュニットを考える
        final long LIMIT_RANGE = 13;

        List<Long> repunitList = generateRepunitList(LIMIT_RANGE);

        List<Long> repunitSums = new ArrayList<>();
        for (int i = 0; i < LIMIT_RANGE; i++) {
            for (int j = 0; j < LIMIT_RANGE; j++) {
                for (int k = 0; k < LIMIT_RANGE; k++) {
                    repunitSums.add(
                        repunitList.get(i) + repunitList.get(j) + repunitList.get(k)
                    );
                }
            }
        }

        System.out.println(repunitSums.stream().distinct().sorted().toList().get(n - 1));
    }

    /*
     * レピュニットのリストを生成
     */
    private static List<Long> generateRepunitList(long limitRange) {
        long limit = pow(10, limitRange);

        List<Long> repunitList = new ArrayList<>();
        long repunit = 0;
        while (repunit < limit) {
            repunit = repunit * 10 + 1;
            repunitList.add(repunit);
        }
        return repunitList;
    }

    /*
     * base ^ exp を返す
     */
    private static long pow(long base, long exp) {
        long result = 1;
        for (int i = 0; i < exp; i++) result *= base;
        return result;
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
    }
}