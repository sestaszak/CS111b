public class HighScore {

//    Class HighScore
//
//    String name
//    int score
//
//    HighScore(String n, int s)
//    void setName(String n)
//    String getName()
//    void setScore(int s)
//    int getScore()

    private String name;
    private int score;

    public HighScore(String n, int s){
        //constructor
        name = n;
        score = s;
    }
    public void setName(String n) {
        name = n;
    }
    public String getName() {
        return name;
    }
    public void setScore(int s){
        score = s;
    }
    public int getScore() {
        return score;
    }
}
