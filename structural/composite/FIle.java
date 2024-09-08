package structural.composite;

class File implements IFileSystemComponent {

    private String name;

    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void showDetails() {
        System.out.println("Arquivo: " + name + " | Tamanho: " + size + "KB");
    }

    @Override
    public int getSize() {
        return size;
    }
    
}
