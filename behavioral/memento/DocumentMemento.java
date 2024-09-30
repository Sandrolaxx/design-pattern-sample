package behavioral.memento;

public class DocumentMemento {
 
    private final String savedContent;

    public DocumentMemento(String content) {
        this.savedContent = content;
    }

    public String getSavedContent() {
        return savedContent;
    }
    
}
