/**
 * Created by angjelinmalaj on 2/8/17.
 */

public class BinarySearch extends RunTime implements SearchInterface {

    @Override
    public int search(int[] listOfNumbers, int target) {
        int index = -1;

        long startTime = System.nanoTime();


		/* do your search here */
        int beg = 0;
        int end = listOfNumbers.length-1;
        int mid;

        while (beg < end) {
            mid = (beg+end)/2;

            if (listOfNumbers[mid] == target) {
                index = mid;
                break;
            }
            else if (listOfNumbers[mid] > target) {
                end = mid-1;
            }
            else {
                beg = mid+1;
            }
        }

        long endTime = System.nanoTime();
        long runTime = endTime - startTime;

        this.addRuntime(runTime);

        return index;
    }

}

