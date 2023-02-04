import java.util.*;
import java.io.*;

public class PrintAPath {
    static List<Integer> simplePath;
    static boolean[] isVisited;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        st = new StringTokenizer(buff.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
        int[] a = new int[m];
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(buff.readLine());
            a[i] = Integer.parseInt(st.nextToken())-1;
            b[i] = Integer.parseInt(st.nextToken())-1;
        }

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            graph.get(b[i]).add(a[i]);
            graph.get(a[i]).add(b[i]);
        }

        isVisited = new boolean[n];
        simplePath = new ArrayList<>();
        simplePath.add(0);
        dfs(0, n-1);
    }

    private static void dfs(int current, int goal) {
        if (current == goal) {
            StringBuilder result = new StringBuilder();
            for (Integer path : simplePath) {
                result.append(path+1).append(" ");
            }
            System.out.println(result.toString().substring(0, result.length()-1));
            System.exit(0);
        }

        isVisited[current] = true;
        for (int i = 0, size = graph.get(current).size(); i < size; i++) {
            int next = graph.get(current).get(i);
            if (isVisited[next]) continue;
            simplePath.add(next);
            dfs(next, goal);
            simplePath.remove((Integer)next);
        }
    }
}