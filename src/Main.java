import java.util.ArrayList;
import java.util.Random;

public class Main {
    enum SortingType {
        QUICK,
        SHELL,
        MERGE,
        BUBBLE
    }

    // ФАБРИЧНИЙ МЕТОД
    public static Sorter getSorter(SortingType type) {
        return switch (type) {
            case BUBBLE -> new BubbleSorter();
            case SHELL -> new ShellSorter();
            case MERGE -> new MergeSorter();
            case QUICK -> new QuickSorter();
        };
    }

    // ГЕНЕРАЦІЯ ЕЛЕМЕНТІВ МАСИВУ
    public static ArrayList<Integer> generateArray(int size, int range) {
        ArrayList<Integer> array = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array.add(random.nextInt(range));
        }

        return array;
    }

    // СОРТУВАННЯ ТА ВИМІРЮВАННЯ ЗАТРАЧЕНОГО НА НЬОГО ЧАСУ
    public static void measureSortingTime(ArrayList<Integer> array, Sorter sorter) {
        long startTime = System.currentTimeMillis();
        ArrayList<Integer> sortedArray = sorter.sort(array);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Sorting time: " + elapsedTime + " milliseconds");
        System.out.println("Sorted array: ");
        printFirst50Elements(sortedArray);
    }

    // ВІДМАЛЬОВКА ГРАНИЦЬ
    public static void printer(char symbol) {
        int count = 150;

        String toPrint = new String(new char[count]).replace('\0', symbol);
        System.out.println(toPrint);
    }

    // ВИВЕДЕННЯ ПЕРШИХ 50 ЕЛЕМЕНТІВ
    public static void printFirst50Elements(ArrayList<Integer> array) {
        int limit = Math.min(50, array.size());
        for (int i = 0; i < limit; i++) {
            System.out.print(array.get(i));
            if (i < limit - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        for (int count : new int[]{10, 1000, 10000, 1000000}) {
            System.out.println(" ");
            /*System.out.println("##############################");*/
            printer('#');
            System.out.println("_______Array size_______: " + count);

            ArrayList<Integer> array = generateArray(count, count); // можна по ідеї і не count передавати 2 аргументом
            // але якщо згенерується багато нулів то так само по
            // ідеї може вивестися 50 нулів, і буде не гарно
            for (SortingType type : SortingType.values()) {
                System.out.println(" ");
                System.out.println("Sorting type: " + type);

                Sorter sorter = getSorter(type);

                // !!!Якщо передбачається зміна – робите на вході глибоку копію! Час копіювання масиву НЕ включається до підрахунку часу сортування!!!
                // ось те саме копіювання, воно перед методом сортування, тому на час сортування не впливає
                ArrayList<Integer> arrayCopy = new ArrayList<>(array);

                measureSortingTime(arrayCopy, sorter);
            }

            printer('-');
        }
    }
}