import java.util.*;

public class LadderTakahashi {

    private static int maxFloor = 1;

    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        Map<Integer, List<Integer>> ladder = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int a = io.nextInt();
            int b = io.nextInt();

            if (!ladder.containsKey(a)) ladder.put(a, new ArrayList<Integer>());
            if (!ladder.containsKey(b)) ladder.put(b, new ArrayList<Integer>());

            ladder.get(a).add(b);
            ladder.get(b).add(a);
        }
        io.close();


        Set<Integer> visited = new HashSet<>();
        visited.add(1);

        dfs(1, visited, ladder);
        io.output(maxFloor);
    }

    private static void dfs(int currentFloor, Set<Integer> visited, Map<Integer, List<Integer>> ladder) {

        List<Integer> nextFloorList = ladder.get(currentFloor);
        if (null == nextFloorList) return;

        for (int i = 0, size = nextFloorList.size(); i < size; i++) {
            int nextFloor = nextFloorList.get(i);
            if (!visited.contains(nextFloor)) {
                visited.add(nextFloor);
                maxFloor = Math.max(maxFloor, nextFloor);
                dfs(nextFloor, visited, ladder);
            }
        }
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private int nextInt() {return this.sc.nextInt();}

        private void output(int result) {System.out.println(result);}
    }
}


// import java.util.*;

// public class LadderTakahashi {
// 	public static void main(String[] args) {
// 		Scanner sc = new Scanner(System.in);
// 		TreeMap<Integer, Integer> furthestUpstairsFloor = new TreeMap<Integer, Integer>();
// 		int N = sc.nextInt();
// 		for (int i = 0; i < N; i++) {
// 			int A = sc.nextInt();
// 			int B = sc.nextInt();
// 			int max = Math.max(A, B);
// 			int min = Math.min(A, B);
// 			if (furthestUpstairsFloor.containsKey(min)) {
// 				furthestUpstairsFloor.put(min, Math.max(furthestUpstairsFloor.get(min), max));
// 			} else {
// 				furthestUpstairsFloor.put(min, max);
// 			}
// 		}
// 		sc.close();

// 		int maxFloor = 1;
// 		for (int currentFloor : furthestUpstairsFloor.keySet()) {
// 			if (currentFloor > maxFloor) break;
// 			maxFloor = Math.max(maxFloor, furthestUpstairsFloor.get(currentFloor));
// 		}
// 		System.out.println(maxFloor);
// 	}
// }