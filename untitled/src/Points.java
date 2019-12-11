public class Points {
    private int xPosition;
    private int yPosition;
    private int xEndPosition;
    private int yEndPosition;

    public Points(int xPosition, int yPosition, int xEndPosition, int yEndPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.xEndPosition = xEndPosition;
        this.yEndPosition = yEndPosition;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getxEndPosition() {
        return xEndPosition;
    }

    public void setxEndPosition(int xEndPosition) {
        this.xEndPosition = xEndPosition;
    }

    public int getyEndPosition() {
        return yEndPosition;
    }

    public void setyEndPosition(int yEndPosition) {
        this.yEndPosition = yEndPosition;
    }

    @Override
    public String toString() {
        return "Points{" +
                "xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                ", xEndPosition=" + xEndPosition +
                ", yEndPosition=" + yEndPosition +
                '}';
    }
}
