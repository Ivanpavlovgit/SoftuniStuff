package PointInRectangle;

import java.util.Scanner;

public class Rectangle {
    private Point bottomLeftCorner;
    private Point upperRightCorner;

    public Rectangle (Point bottomLeftCorner,Point upperRightCorner) {
        this.bottomLeftCorner = bottomLeftCorner;
        this.upperRightCorner = upperRightCorner;
    }

    public boolean contains (Point point) {
        return point.getX () >= bottomLeftCorner.getX () && point.getX () <= upperRightCorner.getX () && point.getY () >= bottomLeftCorner.getY () && point.getY () <= upperRightCorner.getY ();
    }

}
