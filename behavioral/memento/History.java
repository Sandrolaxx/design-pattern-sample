package behavioral.memento;

import java.util.Stack;

public class History {

    private Stack<DocumentMemento> historical = new Stack<>();

    public void save(DocumentMemento memento) {
        historical.push(memento);
    }

    public DocumentMemento undo() {
        DocumentMemento nullMemento = new DocumentMemento("Em branco");

        if (!historical.isEmpty()) {
            historical.pop();

            return historical.isEmpty() ? nullMemento : historical.lastElement();
        }
        
        return nullMemento;
    }

}
