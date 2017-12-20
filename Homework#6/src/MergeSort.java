/**
 * Created by angjelinmalaj on 5/12/17.
 */
public class MergeSort < T extends java.lang.Comparable<? super T>> extends RunTime
 implements  SortInterface<T>{


    @Override
    public void sort(T[] arrayToSort) {

        Object[] tempArray = (new Object [arrayToSort.length]);

        long startTime = System.currentTimeMillis();
        mergeSort(arrayToSort, tempArray, 0, arrayToSort.length-1);

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        addRuntime(totalTime);


    }

    private void mergeSort(T[] array, Object[] tempArray, int first, int last) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergeSort(array, tempArray, first, mid);
            mergeSort(array, tempArray, mid+1, last);
            merge(array, tempArray, first, mid, last);
        }
    }

    private void merge(T[] array, Object[] tempArray, int first, int mid, int last) {

        int first1 = first;
        int last1 = mid;

        int first2 = mid + 1;
        int last2 = last;
        int index = first1;

        while ((first1 <=last1) && (first2 <= last2)) {

            if (array[first1].compareTo(array[first2]) < 0) {

                tempArray[index] = array[first1];
                first1++;

            } else {

                tempArray[index] = array[first2];
                first2++;
            }

            index++;

        }

        while (first <= last1) {
            tempArray[index] = array[first];
            first1++;
            index++;
        }

        while ( first2 <= last2) {
            tempArray[index] = array[first2];
            first2++;
            index++;
        }

        for (int i = first; i <= last; i++) {
            array[i] = (T) tempArray[i];
        }
    }

}
    
