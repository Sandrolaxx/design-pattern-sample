package structural.proxy;

public class RealImage implements IImage {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;

        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Carregando " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Exibindo " + fileName);
    }

}
