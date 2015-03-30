import java.util.*;

/**
 * Created by Nathan on 3/29/2015.
 */
public class MergeSorter {

    public static List<Student> mergeSort(List<Student> a) {
        List<Student> copyBuffer = new ArrayList<Student>(a.size());
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
            if (i1 > middle)
                copyBuffer.set(i, a.get(i2++));
            else if (i2 > high)
                copyBuffer.set(i, a.get(i1++));
            else if (a.get(i1).getScore() < a.get(i2).getScore())
                copyBuffer.set(i, a.get(i1++));
            else
                copyBuffer.set(i, a.get(i2++));
        }

        for (int i = low; i <- high; i++) {
            a.set(i, copyBuffer.get(i));
        }

    }
}
