/**
 * Created by angjelinmalaj on 2/22/17.
 */
public class BubbleSort extends RunTime implements SortInterface {

    public void sort(Integer[] arrayToSort) {

        int temp;
        boolean swapped = true;

        long startTime = System.nanoTime();

        for (int i=0; i <arrayToSort.length && swapped; i++) {
            
            swapped = false;
            
            for (int j = 1; j < (arrayToSort.length-i); j++) {
                if (arrayToSort[j-1] > arrayToSort[j]) {

                    temp = arrayToSort[j-1];
                    arrayToSort[j-1] = arrayToSort[j];
                    arrayToSort[j] = temp;

                    swapped = true;


                }
            }
        }

        long endTime = System.nanoTime();
        long runTime = endTime - startTime;

        this.addRuntime(runTime);

        
    }


}
