package Previous;

public class LineSegment {

    private Point pt1;
    private Point pt2;
//    The second constructor takes a LineSegment as a parameter. It is a copy constructor.

    LineSegment(Point p1, Point p2){
        pt1 = new Point(p1);
        pt2 = new Point(p2);
    }

    LineSegment(LineSegment segment){
        pt1 = new Point(segment.getP1());
        pt2 = new Point(segment.getP2());
    }

//    It should have the following methods (note, no setters required):

    public Point getP1(){
        return new Point(pt1);
    }

    public Point getP2(){
        return new Point(pt2);
    }

    public double length(){
        double xdif = pt1.getX() - pt2.getX();
        double ydif = pt1.getY() - pt2.getY();
        return Math.sqrt(Math.pow(xdif, 2) + Math.pow(ydif, 2));
    }

    public boolean isLongerThan(LineSegment segment){
        double xdif = pt1.getX() - pt2.getX();
        double ydif = pt1.getY() - pt2.getY();
        double dist = Math.sqrt(Math.pow(xdif, 2) + Math.pow(ydif, 2));

        return (dist>segment.length());

        //could do
        //return(this.length()>segment.length());
    }

}
