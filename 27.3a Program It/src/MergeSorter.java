import java.util.*;

/**
 * Created by Nathan on 3/29/2015.
 */
public class MergeSorter {

    public static List<Student> sort(List<Student> a) {
        List<Student> copyBuffer = new ArrayList<>();
        copyBuffer.addAll(a);
        mergeSortHelper(a, copyBuffer, 0, a.size() - 1);
        return copyBuffer;
    }

    public static void mergeSortHelper(List<Student> a, List<Student> copyBuffer, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSortHelper(a, copyBuffer, low, middle);
            mergeSortHelper(a, copyBuffer, middle + 1, high);
            merge(a, copyBuffer, low, middle, high);
        }
    }

    public static void merge(List<Student> a, List<Student> copyBuffer, int low, int middle, int high) {
        int i1 = low;
        int i2 = middle + 1;
        for (int i = low; i <= high; i++) {
            if (i1 > middle) {
                //System.out.println(copyBuffer.get(i));
                copyBuffer.set(i, a.get(i2++));
                //System.out.println(copyBuffer.get(i));
            }
            else if (i2 > high) {
                //System.out.println(copyBuffer.get(i));
                copyBuffer.set(i, a.get(i1++));
                //System.out.println(copyBuffer.get(i).toString());
            }
            else if (a.get(i1).getScore() < a.get(i2).getScore()) {
                //System.out.println(copyBuffer.get(i));
                copyBuffer.set(i, a.get(i1++));
                //System.out.println(copyBuffer.get(i).toString());
            }
            else {
                //System.out.println(copyBuffer.get(i));
                copyBuffer.set(i, a.get(i2++));
                //System.out.println(copyBuffer.get(i).toString());
            }
        }

        for (int i = low; i <= high; i++) {
            a.set(i, copyBuffer.get(i));
        }
    }
}
