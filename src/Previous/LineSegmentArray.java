package Previous;

public class LineSegmentArray {

//    Write a static method that accepts an array of LineSegments and returns the longest of the line segments.
//    If the array is null, or empty, return null.

    public static LineSegment longestLine(LineSegment[] segments){
        LineSegment longestLS;
        int longestIndex = 0;
        if(segments.length==0){
            return null;
        }
        else {
            for (int i = 1; i < segments.length; i++) {
                if (segments[i].length() > segments[longestIndex].length()) {
                    longestIndex = i;
                }
            }
            longestLS = new LineSegment(segments[longestIndex]);
            return longestLS;
        }
    }
}
