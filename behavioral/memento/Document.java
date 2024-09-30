package behavioral.memento;

public class Document {
    
    private String content;

    public void write(String text) {
        content = text;
    }

    public String getContent() {
        return content;
    }

    public DocumentMemento save() {
        return new DocumentMemento(content);
    }

    public void restore(DocumentMemento memento) {
        content = memento.getSavedContent();
    }

}
