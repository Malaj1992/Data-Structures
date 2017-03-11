
public class LinearSearch extends RunTime implements SearchInterface {

    @Override
    public int search(int[] listOfNumbers, int target) {
        int index = -1;

        long startTime = System.nanoTime();


		/* do your search here */
        for (int i=0; i<listOfNumbers.length; i++) {
            if (listOfNumbers[i] == target) {
                index = i;
                break;
            }
        }


        long endTime = System.nanoTime();
        long runTime = endTime - startTime;

        this.addRuntime(runTime);

        return index;
    }

}

