package Previous;

public class Circle {
    private Point center;
    private double radius;

//    Four constructors for circle

    public Circle(Point o, double r){
        center = new Point(o);
        radius = r;
    }
    public Circle(double xValue, double yValue, double r){
        center = new Point(xValue, yValue);
        radius = r;
    }
    public Circle(){
        center = new Point();
        radius = 1.0;
    }
    public Circle(Circle c){
//        center = c.getCenter();
        center = new Point(c.getCenter());
        radius = c.getRadius();
    }
//
//
    public Point getCenter(){
//        return center;
        //this change makes equals method not correct--> updated to check x and y vals instead
        return new Point(center);
    }
//
    public void setCenter(Point p){
        center = new Point(p);
    }
//
//
    public void setX(double value){
        center.setX(value);
    }
//
    public double getX(){
        return center.getX();
//        Point centerCopy = new Point(center);
//        return centerCopy.getX();
    }
//
//
    public void setY(double value){
        center.setY(value);
    }
//
    public double getY(){
        return center.getY();
    }
//
//
    public void setRadius(double value){
        radius = value;
    }
//
    public double getRadius(){
        return radius;
    }
//
//
    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }
//
//
    public String toString(){
        //return a string that states x, y and radius
        return "This is a circle with center " + center.toString() + " and radius " + radius;
    }
//
    public boolean equals(Circle c){
        boolean xEq, yEq, rEq;
        xEq = (center.getX() == c.getX());
        yEq = (center.getY() == c.getY());
        rEq = (radius == c.getRadius());

        return (xEq & yEq & rEq);
    }
//
//
    public boolean doesOverlap(Circle c){
        double xdif = c.getX() - center.getX();
        double ydif = c.getY() - center.getY();
        double centDist = Math.sqrt(Math.pow(xdif, 2) + Math.pow(ydif, 2));
        double rsum = c.getRadius() + radius;
        // sum of radius > distance between centers
        return(rsum > centDist);
    }
}
