public class Circle {
    private Point center;
    private double radius;

//    Four constructors for circle

//    Circle(Point o, double r)
//    Circle(double xValue, double yValue, double r)
//    Circle()
//    Circle(Circle c)
//
//
    public Point getCenter(){
        return center;
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
        return "This is a string";
    }
//
    public boolean equals(Circle c){
        return true;
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
