
public class Driver implements DriverInterface {

    public int[] getListOfNumbers() {

        int[] listOfNumbers = new int[10000000];

        for (int i=0; i< listOfNumbers.length; i++) {

            listOfNumbers[i] = i+1;
        }

        return listOfNumbers;
    }

    public int[] getTargets() {

        int[] targets = new int[] {500, 10000, 100000, 1000000, 5000000, 7500000, 10000000};
        return targets;
    }

    public RunTime runLinearSearch(int[] listOfNumbers, int target, int numberOfTimes) {

        LinearSearch obj = new LinearSearch();

        for (int i=0; i<numberOfTimes; i++) {
            obj.search(listOfNumbers, target);
        }

        long[] runTimes = obj.getRunTimes();

        RunTime r = new RunTime();

        for (int i=0; i<runTimes.length; i++) {
            r.addRuntime(runTimes[i]);
        }

        return r;
    }

    public RunTime runBinarySearch(int[] listOfNumbers, int target,	int numberOfTimes) {

        BinarySearch obj = new BinarySearch();

        for (int i=0; i<numberOfTimes; i++) {
            obj.search(listOfNumbers, target);
        }

        long[] runTimes = obj.getRunTimes();

        RunTime r = new RunTime();

        for (int i=0; i<runTimes.length; i++) {
            r.addRuntime(runTimes[i]);
        }

        return r;
    }

    public static void main(String args[]) {

        Driver driver = new Driver();

        int[] listOfNumbers = driver.getListOfNumbers();
        int[] targets = driver.getTargets();
        int numberOfTimes = 100;

        for (int i=0; i<targets.length; i++) {
            RunTime linearSearchRunTime = driver.runLinearSearch(listOfNumbers, targets[i], numberOfTimes);

            System.out.println("Linear search runtime for " + targets[i] + " is " + linearSearchRunTime.getAverageRunTime());
        }

        for (int i=0; i<targets.length; i++) {
            RunTime binarySearchRunTime = driver.runBinarySearch(listOfNumbers, targets[i], numberOfTimes);

            System.out.println("Binary search runtime for " + targets[i] + " is " + binarySearchRunTime.getAverageRunTime());
        }
    }

}