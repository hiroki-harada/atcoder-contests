import java.util.*;

public class Random {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int h = io.nextInt();
        int w = io.nextInt();
        String[] s = io.nextArray(h);
        String[] t = io.nextArray(h);
        io.close();

        // 行と列を入れ替え、ソート
        List<String> sList = new ArrayList<>();
        List<String> tList = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            StringBuilder sSb = new StringBuilder();
            StringBuilder tSb = new StringBuilder();
            for (int j = 0; j < h; j++) {
                sSb.append(s[j].charAt(i));
                tSb.append(t[j].charAt(i));
            }
            sList.add(sSb.toString());
            tList.add(tSb.toString());
        }
        Collections.sort(sList);
        Collections.sort(tList);

        for (int i = 0; i < w; i++) {
            if (!sList.get(i).equals(tList.get(i))) {
                io.output("No");
                return;
            }
        }
        io.output("Yes");
    }


    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private int nextInt() {return this.sc.nextInt();}

        private String[] nextArray(int size) {
            String[] array = new String[size];
            for (int i = 0; i < size; i++) array[i] = this.sc.next();
            return array;
        }

        private <T> void output(T result) {System.out.println(result);}
    }
}