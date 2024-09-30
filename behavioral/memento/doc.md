# Memento

### Cenário de problema📝

Imagine que você está desenvolvendo um editor de texto com uma funcionalidade de "desfazer" (undo) e "refazer" (redo). No editor, os usuários podem fazer alterações no documento e, caso algo saia errado, eles podem desfazer essas alterações e retornar a um estado anterior do documento. 

Se o editor armazenar diretamente cada estado em variáveis ou gerenciar essas mudanças dentro do objeto principal do documento, o código pode ficar muito acoplado e difícil de manter, especialmente conforme a complexidade do documento aumenta. Além disso, manter uma pilha de estados diretamente dentro do documento pode violar o princípio da responsabilidade única (SRP), sobrecarregando o documento com funcionalidades extras.

---

### Utilização do padrão✅

O padrão **Memento** é ideal para este cenário, pois permite salvar o estado interno de um objeto (neste caso, o documento) sem expor os detalhes de sua implementação. Ele também permite restaurar o estado do objeto posteriormente, facilitando a implementação das funcionalidades de "desfazer" e "refazer" sem comprometer o encapsulamento do objeto original.

---

### Exemplo em Java☕

Aqui está um exemplo da implementação do padrão Memento em Java para gerenciar estados de um editor de texto:

```java
// 1
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
```

1. Classe **Document** que armazena e manipula o conteúdo do documento. Ela pode salvar e restaurar o estado usando um memento.

```java
// 1
public class DocumentMemento {
    private final String savedContent;

    public DocumentMemento(String content) {
        this.savedContent = content;
    }

    public String getSavedContent() {
        return savedContent;
    }
}
```

1. Classe **DocumentMemento** que representa o estado salvo do documento. Ela armazena o estado de forma imutável.

```java
// 1
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
```

1. Classe **History** que mantém uma pilha de mementos. Isso permite ao usuário "desfazer" ações e retornar a estados anteriores.

---

### Utilizando Memento

Aqui está um exemplo de como utilizar o padrão Memento para implementar "desfazer" em um editor de texto.

```java
public class Application {
    public static void main(String[] args) {
        Document documento = new Document();
        History historico = new History();

        //1
        documento.write("Primeiro rascunho");
        historico.save(documento.save());

        documento.write("Segundo rascunho");
        historico.save(documento.save());

        documento.write("Terceiro rascunho");
        historico.save(documento.save());

        //2
        System.out.println("Conteúdo atual: " + documento.getContent());

        //3
        documento.restore(historico.undo());
        System.out.println("Após desfazer: " + documento.getContent());

        documento.restore(historico.undo());
        System.out.println("Após desfazer novamente: " + documento.getContent());

        documento.restore(historico.undo());
        System.out.println("Após desfazer novamente: " + documento.getContent());
    }
}
```

1. O documento é escrito em dois estados diferentes, e cada estado é salvo no histórico.
2. Exibimos o conteúdo atual do documento.
3. Desfazemos as alterações duas vezes, restaurando o estado anterior do documento a cada passo.

---

### Explicação🤓

- **Classe `Document`:** Representa o objeto que terá seus estados salvos e restaurados. Ele usa mementos para salvar seu estado.
- **Classe `DocumentMemento`:** Armazena o estado salvo do documento de forma imutável, mantendo o encapsulamento do documento.
- **Classe `History`:** Gerencia os mementos, fornecendo funcionalidades de "desfazer" que restauram o documento ao estado anterior.

---

### Quando utilizar?🤔

O padrão **Memento** é útil quando:
- Você precisa salvar e restaurar estados anteriores de um objeto sem violar seu encapsulamento.
- A funcionalidade de "desfazer" e "refazer" é necessária em um sistema, como em editores de texto, editores gráficos ou sistemas de transações.

---

### Utilização mundo real🌎

- **Editores de texto e gráficos:** Como o Microsoft Word ou Adobe Photoshop, que permitem aos usuários desfazer e refazer alterações.
- **Jogos de videogame:** Para permitir a recuperação de um estado anterior no jogo, como salvar e carregar o progresso.
- **Sistemas de controle de versão:** Ferramentas como Git utilizam o conceito de memento para armazenar diferentes versões de um projeto.

---

O padrão Memento ajuda a implementar funcionalidades como "desfazer" e "refazer" sem comprometer o design do sistema e mantendo o encapsulamento dos objetos envolvidos.