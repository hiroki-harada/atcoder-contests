import java.util.*;

public class ErrorCorrection {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        String fixedT = in.nextStr();
        String[] s = in.nextStrArray(n);
        in.close();

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) if (isMatch(fixedT, s[i])) result.add(i+1);

        int k = result.size();
        if (k == 0) {
            System.out.println(0);
            System.out.println();
        } else {
            System.out.println(k);

            StringBuilder res = new StringBuilder();
            for (Integer index : result) res.append(index).append(" ");
            System.out.println(res.toString().trim());
        }
    }


    private static boolean isMatch(String original, String target) {

        if (Math.abs(original.length()-target.length()) > 1) return false;

        // 1文字ずつ比較して、1文字違いであるかの判定を行う
        int changes = 0;
        int idxO = 0, idxT = 0;
        while (idxO < original.length() && idxT < target.length()) {

            if (original.charAt(idxO) == target.charAt(idxT)) {
                idxO++;
                idxT++;
            } else {
                if (changes == 1) return false;

                changes++;
                if (original.length() >= target.length()) idxO++;
                if (original.length() <= target.length()) idxT++;
            }
        }

        // 最終文字が異なる場合の補正
        if (idxO < original.length() || idxT < target.length())  changes++;

        return changes <= 1;
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
        private String[] nextStrArray(int size) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < size; i++) list.add(this.sc.next());
            return list.toArray(new String[size]);
        }
    }
}