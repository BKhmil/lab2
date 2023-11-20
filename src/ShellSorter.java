import java.util.ArrayList;

class ShellSorter implements Sorter {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        ArrayList<Integer> sortedArray = new ArrayList<>(input);
        int n = sortedArray.size();

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = sortedArray.get(i);
                int j;
                for (j = i; j >= gap && sortedArray.get(j - gap) > temp; j -= gap) {
                    sortedArray.set(j, sortedArray.get(j - gap));
                }
                sortedArray.set(j, temp);
            }
        }

        return sortedArray;
    }
}
