import java.util.Random;

public class RandomNumberGuesser extends NumberGuesser {
    private boolean newGuess;
//    private int low;
//    private int high;



    public RandomNumberGuesser(int lb, int ub){
        super(lb, ub);
        newGuess = true;
    }

    public int getCurrentGuess(){
        //boolean for get new guess
        //if true randomly generate a guess between upper and lower bound
        //if false return value of last randomly generated guess

        if (newGuess) {
            Random random = new Random();
            currentGuess = random.nextInt((high - low) + 1) + low;
            newGuess = false;
        }

        return currentGuess;
    }

    public void higher(){
        newGuess = true;
        super.higher();
    }

    public void lower(){
        newGuess = true;
        super.lower();
    }
}
