/**
 * Created by angjelinmalaj on 2/22/17.
 */
public class SelectionSort extends RunTime implements SortInterface {

    public void sort (Integer[] arrayToSort ) {

        int temp;
        int iMin;

        long startTime = System.nanoTime();

        for (int i=0; i<arrayToSort.length-1; i++ ) {
            iMin = i;

            for (int j=i+1; j<arrayToSort.length; j++ ){

                if (arrayToSort[j] < arrayToSort [iMin]) {

                    iMin = j;
                }
            }

            if (iMin != i) {

                temp = arrayToSort[iMin];
                arrayToSort[iMin] = arrayToSort[i];
                arrayToSort[i] = temp;
            }
        }

        long endTime = System.nanoTime();
        long runTime = endTime - startTime;

        this.addRuntime(runTime);

    }

}
