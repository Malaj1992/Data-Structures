/**
 * Created by angjelinmalaj on 5/12/17.
 */

    public class Driver implements DriverInterface {


    private static int arraySize;
    private static ArrayType arrayType;

    @Override
    public Integer[] createArray(ArrayType arrayType, int arraySize) {
        return new Integer[0];
    }

    @Override
    public RunTime[] runSorts(ArrayType arrayType, int arraySize, int numberOfTimes) {
        return new RunTime[0];
    }


    public static Integer[] main(String[] args) {


        Integer[] array = new Integer[arraySize];

        if (arrayType == ArrayType.Equal) {

            for (int i = 0; i < arraySize; i++)
                array[i] = 0;

        } else if (arrayType == ArrayType.Random) {

            for (int i = 0; i < arraySize; i++)
                array[i] = (int) Math.random() * arraySize;
        } else if (arrayType == ArrayType.Increasing) {

            for (int i = 0; i < arraySize; i++)
                array[i] = i;
        } else if (arrayType == ArrayType.Decreasing) {

            for (int i = 0; i < arraySize; i++)
                array[i] = arraySize - i;
        } else if (arrayType == ArrayType.IncreasingAndRandom) {

            array[0] = (int) Math.random() * 5;
            for (int i = 1; i < arraySize; i++)
                array[i] = array[i - 1] + ((int) Math.random() * 5);

        }


        return array;


    }

    Driver driver = new Driver();

    RunTime[] runtime = driver.runSorts(ArrayType.Increasing, 1000, 10);
}


