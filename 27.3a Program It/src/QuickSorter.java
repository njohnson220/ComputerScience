import java.util.List;

/**
 * Created by Nathan on 3/31/2015.
 */
public class QuickSorter {
    public static void sort(List<Student> unsortedList) {
        int right = unsortedList.size() - 1;
        sortHelper(unsortedList, 0, right);
    }

    public static void sortHelper(List<Student> unsortedList, int left, int right) {
        if (left >= right) {
            return;
        }

        int i = left;
        int j = right;
        int pivotValue = unsortedList.get((left + right) / 2).getScore();
        while (i < j) {
            while (unsortedList.get(i).getScore() < pivotValue) {
                i++;
            }
            while (pivotValue < unsortedList.get(j).getScore()) {
                j--;
            }
            if (i <= j) {
                Student temp = unsortedList.get(i);
                unsortedList.set(i, unsortedList.get(j));
                unsortedList.set(j, temp);
                i++;
                j--;
            }
        }
        sortHelper(unsortedList, left, j);
        sortHelper(unsortedList, i, right);
    }
}
