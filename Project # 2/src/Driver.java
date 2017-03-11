
public class Driver implements DriverInterface {

    public Integer[] createArray(ArrayType arrayType, int arraySize) {
        Integer[] arr = new Integer[arraySize];

        if (arrayType == ArrayType.Equal) {
            for (int i = 0; i < arraySize; i++)
                arr[i] = 0;
        } else if (arrayType == ArrayType.Random) {
            for (int i = 0; i < arraySize; i++)
                arr[i] = (int) (Math.random() * Integer.MAX_VALUE);
        } else if (arrayType == ArrayType.Increasing) {
            for (int i = 0; i < arraySize; i++)
                arr[i] = i;
        } else if (arrayType == ArrayType.Decreasing) {
            for (int i = 0; i < arraySize; i++)
                arr[i] = arraySize - i;
        } else if (arrayType == ArrayType.IncreasingAndRandom) {
            int size1 = (int) (0.9 * arraySize);
            int size2 = arraySize - size1;

            for (int i = 0; i <size1; i++)
                arr[i] = i;

            for (int i = size1; i < arraySize; i++)
                arr[i] = size2 + (int) (Math.random() * (arraySize - size1));
        }

        return arr;
    }

    public RunTime runSort(SortType sortType, ArrayType arrayType, int arraySize, int numberOfTimes) {
        RunTime runtime = new RunTime();
        for (int i = 0; i < numberOfTimes; i++) {
            Integer[] arr = createArray(arrayType, arraySize);

            if (sortType == SortType.BubbleSort) {
                BubbleSort bubble = new BubbleSort();
                bubble.sort(arr);

                runtime.addRuntime(bubble.getLastRunTime());

            } else if (sortType == SortType.SelectionSort) {
                SelectionSort selection = new SelectionSort();
                selection.sort(arr);

                runtime.addRuntime(selection.getLastRunTime());
            } else if (sortType == SortType.InsertionSort) {
                InsertionSort insertion = new InsertionSort();
                insertion.sort(arr);
                runtime.addRuntime(insertion.getLastRunTime());

            }
        }

//            //System.out.print(runtime.getLastRunTime() + " ");
        
        
        return runtime;
    }

    public static void main(String[] args) {
         /*
          *
    1,000 equal Integers.
    1,000 random Integers.
    1,000 increasing Integers.
    1,000 decreasing Integers.
    1,000 increasing and random Integers.
    10,000 equal Integers.
    10,000 random Integers.
    10,000 increasing Integers.
    10,000 decreasing Integers.
    10,000 increasing and random Integers.

          */
        Driver driver = new Driver();

        //System.out.println("BubbleSort, Equal, 1000");
        RunTime r = driver.runSort(SortType.BubbleSort, ArrayType.Equal, 1000, 10);
        //System.out.println(" --- " + r.getAverageRunTime());

        //System.out.println("SelectionSort, Equal, 1000");
        r = driver.runSort(SortType.SelectionSort, ArrayType.Equal, 1000, 10);
        //System.out.println(" --- " + r.getAverageRunTime());

        //System.out.println("InsertionSort, Equal, 1000");
        r = driver.runSort(SortType.InsertionSort, ArrayType.Equal, 1000, 10);
        //System.out.println(" --- " + r.getAverageRunTime());

        //System.out.println("BubbleSort, Random, 1000");
        r = driver.runSort(SortType.BubbleSort, ArrayType.Random, 1000, 10);
        //System.out.println(" --- " + r.getAverageRunTime());

        //System.out.println("SelectionSort, Random, 1000");
        r = driver.runSort(SortType.SelectionSort, ArrayType.Random, 1000, 10);
        //System.out.println(" --- " + r.getAverageRunTime());

        //System.out.println("InsertionSort, Random, 1000");
        r = driver.runSort(SortType.InsertionSort, ArrayType.Random, 1000, 10);
        //System.out.println(" --- " + r.getAverageRunTime());

        //System.out.println("BubbleSort, Increasing, 1000");
        r = driver.runSort(SortType.BubbleSort, ArrayType.Increasing, 1000, 10);
        //System.out.println(" --- " + r.getAverageRunTime());

        //System.out.println("InsertionSort, Increasing, 1000");
        r = driver.runSort(SortType.InsertionSort, ArrayType.Increasing, 1000, 10);
        //System.out.println(" --- " + r.getAverageRunTime());

        //System.out.println("SelectionSort, Increasing, 1000");
        r = driver.runSort(SortType.SelectionSort, ArrayType.Increasing, 1000, 10);
        //System.out.println(" --- " + r.getAverageRunTime());

        //System.out.println("BubbleSort, Decreasing, 1000");
        r = driver.runSort(SortType.BubbleSort, ArrayType.Decreasing, 1000, 10);
        //System.out.println(" --- " + r.getAverageRunTime());

        //System.out.println("InsertionSort, Decreasing, 1000");
        r = driver.runSort(SortType.InsertionSort, ArrayType.Decreasing, 1000, 10);
        //System.out.println(" --- " + r.getAverageRunTime());

        //System.out.println("SelectionSort, Decreasing, 1000");
        r = driver.runSort(SortType.SelectionSort, ArrayType.Decreasing, 1000, 10);
        //System.out.println(" --- " + r.getAverageRunTime());

        //System.out.println("BubbleSort, Increasing and Random, 1000");
        r = driver.runSort(SortType.BubbleSort, ArrayType.IncreasingAndRandom, 1000, 10);
        //System.out.println(" --- " + r.getAverageRunTime());

        //System.out.println("InsertionSort, Increasing and Random, 1000");
        r = driver.runSort(SortType.InsertionSort, ArrayType.IncreasingAndRandom, 1000, 10);
        //System.out.println(" --- " + r.getAverageRunTime());

        //System.out.println("SelectionSort, Increasing and Random, 1000");
        r = driver.runSort(SortType.SelectionSort, ArrayType.IncreasingAndRandom, 1000, 10);
        //System.out.println(" --- " + r.getAverageRunTime());



    }
}

