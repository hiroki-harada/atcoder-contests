import java.util.*;

public class Flavors {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int[] f = new int[n];
        int[] s = new int[n];
        Map<Integer, List<Integer>> flavorGroups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            f[i] = io.nextInt();
            s[i] = io.nextInt();
            flavorGroups.computeIfAbsent(f[i], k -> new ArrayList<>()).add(s[i]);
        }
        io.close();

        // 同じ味の組み合わせの場合の、最大値を求める
        long maxOnSame = calculateMaxSatisfactionOnSameFlavors(flavorGroups);
        // 異なる味の組み合わせの場合の、最大値を求める
        long maxOnDiff = calculateMaxSatisfactionOnDiffFlavors(flavorGroups);

        io.output(Math.max(maxOnSame, maxOnDiff));
    }

    private static long calculateMaxSatisfactionOnSameFlavors(Map<Integer, List<Integer>> flavorGroups) {
        long result = 0;
        for (List<Integer> satisfactions : flavorGroups.values()) {
            if (satisfactions.size() <= 1) continue;

            Collections.sort(satisfactions, Collections.reverseOrder());
            result = Math.max(result, satisfactions.get(0) + satisfactions.get(1) / 2);
        }
        return result;
    }

    private static long calculateMaxSatisfactionOnDiffFlavors(Map<Integer, List<Integer>> flavorGroups) {
        if (flavorGroups.keySet().size() == 1) return 0;

        List<Integer> maxFlavor = new ArrayList<>();
        for (List<Integer> satisfactions : flavorGroups.values()) {
            Collections.sort(satisfactions, Collections.reverseOrder());
            maxFlavor.add(satisfactions.get(0));
        }
        Collections.sort(maxFlavor, Collections.reverseOrder());
        return maxFlavor.get(0) + maxFlavor.get(1);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private void output(long result) {System.out.println(result);}
    }
}