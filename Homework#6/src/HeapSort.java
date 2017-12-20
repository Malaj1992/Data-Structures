/**
 * Created by angjelinmalaj on 5/12/17.
 */
public class HeapSort <T extends java.lang.Comparable<? super T >> extends RunTime
implements SortInterface<T> {

    private T[] heap;
    private int heapSize;


    public void sort (T [] arrayToSort) {

        heap = arrayToSort;
        heapSize = heap.length;

        long startTime = System.currentTimeMillis();

        heapSort();

        long endTime = System.currentTimeMillis();
        long totalTime = endTime -startTime;

        addRuntime(totalTime);
    }

    private void heapSort() {

        int count = heapSize;

        heapify();

        int end = count-1;

        while (end >0) {

            T temp = heap[end];
            heap[end] = heap[0];
            heap [0] =temp;

            siftDown (0);

            end--;
        }
    }

    private void heapify () {

        int start = (heapSize-2) /2; // binary heap

        while (start >= 0) {
            // process "siftDown" at the current "start"

            siftDown(start);

            start--;
        }
    }

    private void siftDown (int node) {

        int root = node;// this is where we end

       int end = heapSize-1;// this is where we end

        // process the nodes with child nodes

        while ((root * 2 +1 ) <= end) {
            int child = root * 2 + 1; // left child

            // pick the right or the left child

            if (child +1 <= end && heap[child].compareTo(heap[child +1]) <0) child = child +1;

            //... then point to the right child instead
             // out of order, hence swap

            if (heap[root].compareTo(heap[child]) < 0) {
                T temp = heap[root];
                heap [root] =  heap[child];
                heap[child] = temp;
                root = child; // update on root for next run
            } else
                return;;
        }
    }
}
