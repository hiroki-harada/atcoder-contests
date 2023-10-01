import java.util.*;

public class VacationTogether {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int d = io.nextInt();
        String[] s = io.nextStrArray(n);
        io.close();

        String[] transposeS = transpose(s, d);

        int seqDay = 0;
        Set<Integer> seqLeisure = new HashSet<>();
        for (int i = 0; i < d; i++) {

            // 全員が暇な日の連続が途切れた
            if (transposeS[i].contains("x")) seqDay = 0;
            // 全員が暇な日が連続している
            else seqDay++;
            seqLeisure.add(seqDay);
        }

        io.output(Collections.max(seqLeisure));
    }

    private static String[] transpose(String[] input, int tLen) {
        var result = new String[tLen];

        for (int i = 0; i < tLen; i++) {
            var sb = new StringBuilder();
            for (int j = 0; j < input.length; j++) sb.append(input[j].charAt(i));
            result[i] = sb.toString();
        }

        return result;
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String[] nextStrArray(int size) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < size; i++) list.add(this.sc.next());
            return list.toArray(new String[size]);
        }
        private void output(int result) {System.out.println(result);}
    }
}