public class Rectangle
{
   private final Points points;

    private Rectangle(int xPosition, int yPosition, int xEndPosition, int yEndPosition) {
        this.points = new Points(xPosition,yPosition,xEndPosition,yEndPosition);
    }

    public static Rectangle newInstance(int xPosition, int yPosition, int xEndPosition, int yEndPosition){
        return new Rectangle(xPosition,yPosition,xEndPosition,yEndPosition);
    }

    public void rotate(int xPosition, int yPosition, int xEndPosition, int yEndPosition){


    }

    public Points getPoints() {
        return points;
    }

    public void stretch(int xEndPosition, int yEndPosition){
        points.setxEndPosition(xEndPosition);
        points.setyEndPosition(yEndPosition);
    }

    public void move(int xPosition, int yPosition, int xEndPosition, int yEndPosition){
        points.setxPosition(xPosition);
        points.setyPosition(yPosition);

        points.setxEndPosition(xEndPosition);
        points.setyEndPosition(yEndPosition);
    }

    @Override
    public String toString() {
        return points.toString();
    }
}