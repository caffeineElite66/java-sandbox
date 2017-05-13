
class LoveRectangle {

//  public static void main (String[] args) {
//    LoveRectangle l = new LoveRectangle();
//    Rectangle r1 = l.new Rectangle(3, 4, 10, 2);
//    Rectangle r2 = l.new Rectangle(10, 0, 5, 7);
//    System.out.println((l.isIntersected(r1, r2)) ? "YES" : "NO");
//  }
//
//  public Rectangle getLoveRectangle(Rectangle r1, Rectangle r2) {
//
//  }
//
//  public boolean isIntersected(Rectangle r1, Rectangle r2) {
//
//    boolean xIsInRange = false;
//    boolean yIsInRange = false;
//
//    // check if r1.x range is in r2.x range
//    if(isInRange(r2.leftX.intValue(), r2.leftX + r2.width, r1.leftX.intValue())) {
//      xIsInRange = true;
//    } else if (isInRange(r2.leftX.intValue(), r2.leftX + r2.width, r1.leftX + r1.width)) {
//      xIsInRange = true;
//    }
//
//    // check if r1.y range is in r2.y range
//    if (isInRange(r2.bottomY.intValue(), r2.bottomY + r2.height, r1.bottomY.intValue())) {
//      yIsInRange = true;
//    } else if (isInRange(r2.bottomY.intValue(), r2.bottomY + r2.height, r1.bottomY + r1.height)) {
//      yIsInRange = true;
//    }
//
//    return (xIsInRange && yIsInRange);
//
//  }
//
//  public boolean isInRange(int start, int end, int point) {
//    if (point >= start && point <= end) {
//      return true;
//    }
//    else return false;
//  }
//
//  public class Rectangle {
//
//    // coordinates of bottom left corner
//    Integer leftX;
//    Integer bottomY;
//
//    // dimensions
//    Integer width;
//    Integer height;
//
//    public Rectangle(Integer leftX, Integer bottomY, Integer width, Integer height) {
//        this.leftX = leftX;
//        this.bottomY = bottomY;
//        this.width  = width;
//        this.height = height;
//    }
//
//    public Rectangle() {}
//
//    public String toString() {
//        return String.format("(%d, %d, %d, %d)", leftX, bottomY, width, height);
//    }
//  }
}
