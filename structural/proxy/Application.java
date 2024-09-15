package structural.proxy;

public class Application {
    public static void main(String[] args) {
        IImage image1 = new ProxyImage("image1.jpg");
        IImage image2 = new ProxyImage("image2.jpg");

        //2
        image1.display();
        //3
        image1.display();

        //4
        image2.display();
        //5
        image2.display();
    }
}
