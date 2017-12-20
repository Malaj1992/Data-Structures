public class QuickSort<T extends java.lang.Comparable<? super T>> extends RunTime implements SortInterface<T> {


    public  enum PivotType {
        FirstElement, RandomElement, MidOfFirstMidLastElement;

    }

        public static final QuickSort.PivotType FirstElement = null, RandomElement = null, MidOfFirstMidLastElement = null;


    public static QuickSort.PivotType[] values()
    {
        QuickSort.PivotType[] pt = new QuickSort.PivotType[3];
        int index = 0;
        for (QuickSort.PivotType c : QuickSort.PivotType.values())
            pt[index++] = c;

        return pt;
    }

    public static QuickSort.PivotType valueOf(String name) throws IllegalArgumentException, NullPointerException
    {
        if (name == null)
            throw new NullPointerException();
        else if (name.equals("First"))
            return FirstElement;
        else if (name.equals("Random"))
            return RandomElement;
        else if (name.equals("Mid"))
            return MidOfFirstMidLastElement;
        else
            throw new IllegalArgumentException();
    }




    private QuickSort.PivotType pivotType;

    public QuickSort() {
        pivotType = FirstElement;
    }

    public QuickSort.PivotType getPivotType() {
        return pivotType;
    }

    public void setPivotType(QuickSort.PivotType pivotType) {
        this.pivotType = pivotType;
    }

    public void sort(T[] array) {

        long startTime = System.currentTimeMillis();
        quickSort(array, 0, array.length - 1);

        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        addRuntime(totalTime);
    }

    private void quickSort(T[] array, int firstIndex, int lastIndex) {
        int pivotIndex;
        if (firstIndex < lastIndex) {
            pivotIndex = partition(array, firstIndex, lastIndex);
            quickSort(array, firstIndex, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, lastIndex);
        }
    }

    public void choosePivot(T[] array, int first, int last) {
        // after this method returns, the chosen pivot is
        // always in the first location in the segment of the
        // array being sorted
        return;
    }



    private int partition(T[] array, int first, int last) {
        // ---------------------------------------------------------
        // Partitions an array for quicksort.
        // Precondition: theArray[ first ... last] where first <= last.
        // Postcondition: Returns the index of the pivot element of
        // theArray[ first ... last]. Upon completion of the method,
        // this will be the index value lastS1 such that
        // S1 = theArray[first ... lastS1-1] < pivot
        // theArray[lastS1] == pivot
        // S2 = theArray[lastS1+1 ... last] >= pivot
        // Calls: choosePivot.
        // ---------------------------------------------------------

        // tempItem is used to swap elements in the array
        T tempItem;

        // place pivot in theArray[first]

        choosePivot(array, first, last);
        T pivot = array[first]; // reference pivot

        // initially, everything but pivot is in unknown
        int lastS1 = first; // index of last item in S1

        // move one item at a time until unknown region is empty
        for (int firstUnknown = first + 1; firstUnknown <= last; firstUnknown++) {
            // Invariant: theArray[first+1 ... lastS1] < pivot

            // move item from unknown to proper region
            if (array[firstUnknown].compareTo(pivot) < 0) {
                // item from unknown belongs in S1
                ++lastS1;
                tempItem = array[firstUnknown];
                array[firstUnknown] = array[lastS1];
                array[lastS1] = tempItem;
            } // end if
            // else item from unknown belongs in S2
        } // end for

        // place pivot in proper position and mark its location
        tempItem = array[first];
        array[first] = array[lastS1];
        array[lastS1] = tempItem;

        return lastS1;
    } // end partition
}