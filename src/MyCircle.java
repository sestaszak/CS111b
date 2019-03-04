

public class MyCircle {

    private double x;
    private double y;
    private double radius;

    public void setX(double xx){
        x = xx;
    }

    public double getX(){
        return x;
    }

    public void setY(double yy){
        y = yy;
    }

    public double getY(){
        return y;
    }

    public void setRadius(double rr){
        radius = rr;
    }

    public double getRadius(){
        return radius;
    }

    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }

    public boolean doesOverlap(MyCircle otherCircle){
        double xdif = otherCircle.getX() - x;
        double ydif = otherCircle.getY() - y;
        double centDist = Math.sqrt(Math.pow(xdif, 2) + Math.pow(ydif, 2));
        double rsum = otherCircle.getRadius() + radius;
        // sum of radius > distance between centers
        return(rsum > centDist);

    }

}
