import java.util.*;

public class CardsQueryProblem {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        io.nextInt(); // discard n
        int q = io.nextInt();
        io.nextLine(); // discard \n
        String[] query = io.nextStrArray(q);

        List<List<Integer>> boxes = new ArrayList<>();
        for (int i = 0; i < 200001; i++) boxes.add(new ArrayList<>());
        // cardsi := 数i が書かれたカードが入っている箱、その番号の集合
        List<Set<Integer>> cards = new ArrayList<>();
        for (int i = 0; i < 200001; i++) cards.add(new HashSet<>());

        List<String> result = new ArrayList<>();

        for (String queryStrings : query) {
            String[] queryI = queryStrings.split(" ");

            if (queryI[0].equals("1")) {
                int i = Integer.parseInt(queryI[1]);
                int j = Integer.parseInt(queryI[2]);
                boxes.get(j).add(i);
                cards.get(i).add(j);
            }
            if (queryI[0].equals("2")) {
                int i = Integer.parseInt(queryI[1]);
                result.add(makeSortedString(boxes.get(i)));
            }
            if (queryI[0].equals("3")) {
                int i = Integer.parseInt(queryI[1]);
                result.add(makeSortedString(new ArrayList<>(cards.get(i))));
            }
        }
        io.close();

        io.outputList(result, "\n");
    }

    private static String makeSortedString(List<Integer> target) {
        Collections.sort(target);

        StringBuilder result = new StringBuilder();
        for (Integer e : target) result.append(e).append(" ");
        return result.toString().substring(0, result.length() - " ".length());
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextLine() {return this.sc.nextLine();}
        private String[] nextStrArray(int size) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < size; i++) list.add(this.sc.nextLine());
            return list.toArray(new String[size]);
        }
        private <T> void outputList(List<T> list, String delimiter) {
            StringBuilder result = new StringBuilder();
            for (T e : list)  result.append(e).append(delimiter);
            System.out.println(result.toString().substring(0, result.length()-delimiter.length()));
        }
    }
}