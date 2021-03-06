public class NumberGuesser {

    protected int low;
    protected int high;
    protected int currentGuess;
    protected int initLow;
    protected int initHigh;


    public NumberGuesser(int lowerBound, int upperBound){
        // constructor
        low = lowerBound;
        high = upperBound;
        initLow = lowerBound;
        initHigh = upperBound;
    }

    public void higher(){
        low = currentGuess + 1;
    }

    public void lower(){
        high = currentGuess - 1;
    }

    public int getCurrentGuess(){
        currentGuess = (high + low)/2;
        return currentGuess;
    }

    public void reset(){
        high = initHigh;
        low = initLow;
    }
}
