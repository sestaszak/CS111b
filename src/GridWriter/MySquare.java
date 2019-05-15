package GridWriter;

public class MySquare extends GridItem{

    //because a square is a subset of a rectangle,
    // it would be cool to create this class as an extension of the MyRectangle class
    // would need to change some parts of MyRectangle so that MySquare could use them

    private int side;

    //constructor
    public MySquare(int xValue, int yValue, int s){
        x = xValue;
        y = yValue;
        side = s;
    }

    //getArea
    public double getArea(){
        return side * side;
    }

    //containsPoint
    public boolean containsPoint(int xValue, int yValue) {
        return xValue >= x &&
                xValue <= x + side &&
                yValue >= y &&
                yValue <= y + side;
    }

}
