import java.util.ArrayList;

class QuickSorter implements Sorter {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        if (input.size() <= 1) {
            return input;
        }

        int pivot = input.get(input.size() / 2);
        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();

        for (int num : input) {
            if (num < pivot) {
                less.add(num);
            } else if (num > pivot) {
                greater.add(num);
            } else {
                equal.add(num);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.addAll(sort(less));
        result.addAll(equal);
        result.addAll(sort(greater));

        return result;
    }
}
