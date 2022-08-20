import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

class DayCream {

    private interface PARAMETER {
        String DREAM = "dream";
        String DREAMER = "dreamer";
        String ERASE = "erase";
        String ERASER = "eraser";
    }
    private static List<String> LIST_PARAMETER = Arrays.asList(
        PARAMETER.DREAM,
        PARAMETER.DREAMER,
        PARAMETER.ERASE,
        PARAMETER.ERASER
    );
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        sc.close();

        String ans = "YES";
        if (!LIST_PARAMETER.contains(s)) {
            ans = "NO";
        } else {
            s = s.replaceAll(PARAMETER.DREAMER, "xxx")
                    .replaceAll(PARAMETER.DREAM, "xxx")
                    .replaceAll(PARAMETER.ERASER, "xxx")
                    .replaceAll(PARAMETER.ERASE, "xxx")
                    .replaceAll("xxx", "");
            if (s != "") ans = "NO";
        }

        System.out.println(ans);

    }
}