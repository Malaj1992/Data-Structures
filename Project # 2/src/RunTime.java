
public class RunTime implements RuntimeInterface {

    private long[] runTimes = new long[10];
    private int index = 0;

    @Override
    public long getLastRunTime() {
        if (index != 0) {
            return runTimes[index-1];
        } else {
            return 0;
        }
    }

    @Override
    public long[] getRunTimes() {
        // TODO Auto-generated method stub
        return runTimes;
    }

    @Override
    public void resetRunTimes() {
/*		for ( int i = 0 ; i < runTimes.length ; i++ ) {
			runTimes[i] = 0;
		}
		index = 0;
*/
        runTimes = new long[10];
        index = 0;
    }

    @Override
    public void addRuntime(long runTime) {

        if (index < runTimes.length) {
            runTimes[index] = runTime;
            index++;
        } else {
            for ( int i = 0 ; i < (runTimes.length - 1) ; i++ ) {
                runTimes[i] = runTimes[i+1];
            }
            runTimes[9] = runTime;
        }
    }

    @Override
    public double getAverageRunTime() {
        // TODO Auto-generated method stub
        long sum = 0;
        for ( int i = 0 ; i < index; i++) {
            sum = sum + runTimes[i];
        }

        double averageRunTime = (double) sum / index;
        return averageRunTime;
    }

}
