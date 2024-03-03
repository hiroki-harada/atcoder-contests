import java.util.*;

public class ManyReplacement {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        in.nextInt();
        String s = in.nextStr();
        int q = in.nextInt();
        String[] c = new String[q];
        String[] d = new String[q];
        for (int i = 0; i < q; i++) {
            c[i] = in.nextStr();
            d[i] = in.nextStr();
        }
        in.close();

        // {a, a}, {b, b}, ..., {z, z} のペアを作成
        final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        Map<String, String> mapConvert = new HashMap<>();
        for (String str : ALPHABET.split("")) mapConvert.put(str, str);

        // a, b, ..., z がそれぞれ、最終的に何に置換されるか判定
        for (int i = 0; i < q; i++) {
            for (var set : mapConvert.entrySet()) {
                // ci = value, di(= x) の時
                // {key, value} -> {key, di} となるよう更新する
                if (set.getValue().equals(c[i])) mapConvert.put(set.getKey(), d[i]);
            }
        }

        // s の各文字に対応する置換後の文字を、作成した map から取り出す
        StringBuilder result = new StringBuilder();
        for (String str : s.split("")) result.append(mapConvert.get(str));
        System.out.println(result.toString());
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
    }
}
