
public class Point {
    //point class from professor for circle class homework
        private double x;
        private double y;

        public Point(double xValue, double yValue) {
            x = xValue;
            y = yValue;
        }

        public Point(Point p){
            this(p.x, p.y);
        }

        public Point() {
            this(0, 0);
        }

        public void setX(double xValue){
            x = xValue;
        }

        public double getX(){
            return x;
        }

        public void setY(double yValue){
            y = yValue;
        }

        public double getY(){
            return y;
        }

        public boolean equals(Point otherPoint){
            return (this.x == otherPoint.x) && (this.y == otherPoint.y);
        }

        public String toString(){
            return "(" + x + ", " + y + ")";
        }

        public double distance(Point otherPoint){
            double xdif = otherPoint.getX() - x;
            double ydif = otherPoint.getY() - y;
            return Math.sqrt(Math.pow(xdif, 2) + Math.pow(ydif, 2));
        }
}

