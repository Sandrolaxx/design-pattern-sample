# Composite

### Cenário de problema🗃

Imagine que você está criando um sistema que precisa lidar com a estrutura de um sistema de arquivos, onde há **pastas** que podem conter **arquivos** e **outras pastas**. Cada pasta pode ter um número arbitrário de subpastas e arquivos, mas tanto os arquivos quanto as pastas podem ser tratados como "componentes" do sistema de arquivos, permitindo operações como exibir o conteúdo ou calcular o tamanho total.

O problema é que você precisa tratar de maneira uniforme tanto os arquivos quanto as pastas, sem ter que lidar com cada tipo individualmente.

---

### Utilização do padrão✅

O padrão **Composite** se aplica, permitindo que você construa hierarquias de objetos e trate tanto componentes simples (arquivos) quanto compostos (pastas) de forma uniforme.

---

### Exemplo em Java☕


```java
// Interface que define operações comuns para arquivos e pastas
interface IFileSystemComponent {
    void showDetails();
    int getSize();
}
```

```java
// Representa um arquivo, que é um elemento "folha"
class File implements IFileSystemComponent {
    private String name;
    private int size;  // Tamanho do arquivo em KB

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
```


```java
// Representa uma pasta, que pode conter arquivos e outras pastas
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
```

```java
public class Application {
    public static void main(String[] args) {
        // Criando arquivos
        File file1 = new File("arquivo1.txt", 100);
        File file2 = new File("arquivo2.doc", 200);
        File file3 = new File("imagem.jpg", 500);

        // Criando pastas
        Folder folder1 = new Folder("Documentos");
        Folder folder2 = new Folder("Imagens");
        Folder rootFolder = new Folder("Raiz");

        // Adicionando arquivos e subpastas à pasta
        folder1.addComponent(file1);
        folder1.addComponent(file2);
        folder2.addComponent(file3);

        // Adicionando pastas à pasta raiz
        rootFolder.addComponent(folder1);
        rootFolder.addComponent(folder2);

        // Mostrando detalhes da estrutura
        rootFolder.showDetails();

        // Calculando o tamanho total da pasta raiz
        System.out.println("Tamanho total da pasta 'Raiz': " + rootFolder.getSize() + "KB");
    }
}
```

---

### Utilização do Padrão Composite

- **Tratamento Uniforme**: O **Composite** permite tratar objetos individuais (arquivos) e compostos (pastas) de forma uniforme, ou seja, ambos podem ser manipulados de maneira semelhante.
- **Hierarquia Recursiva**: Com esse padrão, você pode criar estruturas hierárquicas de objetos, onde cada objeto composto pode conter outros objetos simples ou compostos.
- **Facilidade de Extensão**: É fácil adicionar novos tipos de componentes (por exemplo, um **Atalho** ou **Link Simbólico**) sem precisar modificar o código existente.

### Quando Utilizar o Composite

- Quando você precisa representar uma estrutura hierárquica de objetos, como árvores ou gráficos.
- Quando deseja tratar de forma uniforme objetos individuais e composições de objetos.
- Quando há a necessidade de realizar operações em toda a hierarquia de forma recursiva (por exemplo, calcular o tamanho total, exibir detalhes, etc.).

O padrão **Composite** é ideal para problemas onde você tem uma estrutura de componentes que pode ser composta de outros componentes, permitindo a criação de árvores ou hierarquias complexas.