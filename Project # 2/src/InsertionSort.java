/**
 * Created by angjelinmalaj on 2/22/17.
 */
public class InsertionSort extends RunTime implements SortInterface {

    @Override
    public void sort(Integer[] arrayToSort) {

        int temp;

        long startTime = System.nanoTime();

        for (int i= 1; i <arrayToSort.length; i++) {

            int j = i;

            while (j > 0 && arrayToSort[j-1] > arrayToSort[j]) {

                temp = arrayToSort[j];
                arrayToSort[j] = arrayToSort[j-1];
                arrayToSort[j-1] = temp;

                j--;
            }
        }

        long endTime = System.nanoTime();
        long runTime = endTime - startTime;

        this.addRuntime(runTime);


    }
}
