package structural.composite;

public class Application {

    public static void main(String[] args) {

        File file1 = new File("arquivo1.txt", 100);
        File file2 = new File("arquivo2.doc", 200);
        File file3 = new File("imagem.jpg", 500);

        Folder folder1 = new Folder("Documentos");
        Folder folder2 = new Folder("Imagens");
        Folder rootFolder = new Folder("Raiz");

        folder1.addComponent(file1);
        folder1.addComponent(file2);
        folder2.addComponent(file3);

        rootFolder.addComponent(folder1);
        rootFolder.addComponent(folder2);

        rootFolder.showDetails();

        System.out.println("Tamanho total da pasta 'Raiz': " + rootFolder.getSize() + "KB");
    }

}
