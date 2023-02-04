import java.util.*;

public class StringShifting {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        String s = io.nextStr();
        io.close();

        LinkedList<String> resultList = new LinkedList<>();
        for (int i = 0, size = s.length(); i < size; i++) {
            StringBuilder sb = new StringBuilder();
            String si = sb.append(s.substring(i, size))
                          .append(s.substring(0, i)).toString();
            resultList.add(si);
        }
        Collections.sort(resultList);

        io.output(resultList.getFirst());
        io.output(resultList.getLast());
    }


    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private String nextStr() {return this.sc.next();}
        private <T> void output(T result) {System.out.println(result);}
    }
}