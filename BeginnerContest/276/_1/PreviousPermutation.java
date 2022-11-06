import java.util.*;

public class PreviousPermutation {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        Integer[] p = io.nextIntArray(n);
        io.close();

        Permutation.prevPermutation(p);
        io.output(p);
    }


    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private int nextInt() {return this.sc.nextInt();}

        private Integer[] nextIntArray(int size) {
            Integer[] array = new Integer[size];
            for (int i = 0; i < size; i++) array[i] = this.sc.nextInt();
            return array;
        }

        private <T> void output(T[] array){
            for (int i = 0; i < array.length; i++)  System.out.print(array[i] + " ");
            System.out.println();
        }
    }


    private static class Permutation {

        private static <T> void swap(T[] array, int m, int n) {
            T temp = array[m]; array[m] = array[n]; array[n] = temp;
        }

        private static <T extends Comparable<T>> boolean prevPermutation(T[] array) {
            return prevPermutation(array, java.util.Comparator.naturalOrder());
        }

        private static <T> boolean prevPermutation(T[] array, java.util.Comparator<T> comparator) {
            if (array == null | array.length <= 1) return false;

            for (int change = array.length - 2; change >= 0; --change) {
                if (comparator.compare(array[change], array[change + 1]) > 0) {
                    int min = change, max = array.length, halfDiff, mid;
                    while ((halfDiff = max - min >> 1) != 0) {
                        if (comparator.compare(array[change], array[mid = min + halfDiff]) > 0) min = mid;
                        else max = mid;
                    }
                    swap(array, change, min);
                    for (min = change + 1, max = array.length - 1; min < max; ++min, --max) swap(array, min, max);
                    return true;
                }
            }
            return false;
        }
    }
}