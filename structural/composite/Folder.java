package structural.composite;

import java.util.ArrayList;
import java.util.List;

class Folder implements IFileSystemComponent {

    private String name;
    
    private List<IFileSystemComponent> components = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addComponent(IFileSystemComponent component) {
        components.add(component);
    }

    public void removeComponent(IFileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Pasta: " + name);
        for (IFileSystemComponent component : components) {
            component.showDetails();
        }
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (IFileSystemComponent component : components) {
            totalSize += component.getSize();
        }
        return totalSize;
    }
    
}
