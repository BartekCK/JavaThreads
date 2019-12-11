public class Main {

    public static void main(String[] args) {
        // write your code here
        Rectangle rectangle = Rectangle.newInstance(0,0,10,10);
        System.out.println(rectangle);
        rectangle.move(5,5,15,15);
        System.out.println(rectangle);
        rectangle.stretch(20,40);
        System.out.println(rectangle);
        //rectangle.rotate();
    }
}
