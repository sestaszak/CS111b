package ExceptionHW.NumberGuessers;

public class NumberGuesser {
	
	protected int high;
	protected int low;
	
	private int originalHigh;
	private int originalLow;
	
	public NumberGuesser(int l, int h) {
		low = originalLow = l;
		high = originalHigh = h;
	}
	
	public int getCurrentGuess() {
		return (high + low) / 2;
	}

//	numberguesser should throw IllegalStateException
//	game should have try-catch handling
	
	public void higher() {
		if(high<=low){
			throw new IllegalStateException("can't call higher");
		}
		low = getCurrentGuess() + 1;
	}
	
	public void lower() {
		if(low>=high){
			throw new IllegalStateException("can't call lower");
		}
		high = getCurrentGuess() - 1;
	}
	
	public void reset() {
		low = originalLow;
		high = originalHigh;
	}
}