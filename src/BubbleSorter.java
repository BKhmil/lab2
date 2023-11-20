import java.util.ArrayList;
import java.util.Collections;

class BubbleSorter implements Sorter {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        ArrayList<Integer> sortedArray = new ArrayList<>(input);
        int arrSize = sortedArray.size();
        boolean isSwapped;

        do {
            isSwapped = false;
            for (int i = 1; i < arrSize; i++) {
                if (sortedArray.get(i - 1) > sortedArray.get(i)) {
                    Collections.swap(sortedArray, i - 1, i);
                    isSwapped = true;
                }
            }
            arrSize--;
        } while (isSwapped);

        return sortedArray;
    }
}
