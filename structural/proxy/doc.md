# Proxy

### Cenário do problema

Imagine que você está desenvolvendo um sistema de gerenciamento de imagens que precisa exibir várias imagens de alta resolução. Carregar todas as imagens de uma vez pode consumir muita memória e causar lentidão.

---

### Utilização do padrão✅

Para otimizar o desempenho, você pode usar o padrão **Proxy**, que carrega a imagem real apenas quando ela for realmente necessária (ou seja, quando o método `display()` for chamado).

---

### Exemplo em Java☕

```java
//1
public interface IImage {
    void display();
}
```
1. Interface comum para a imagem real e o proxy

```java
//1
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
```
1. Classe que representa a imagem real

```java
//1
public class ProxyImage implements IImage {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }

        realImage.display();
    }
}
```
1. Classe Proxy para controlar o acesso à imagem real

```java
//1
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
```
1. Classe cliente que utiliza o proxy
2. A imagem será carregada na primeira vez que display for chamado
3. Apenas Exibindo image1.jpg (imagem já carregada)
4. A imagem 2 só será carregada quando for chamada
5. Apenas Exibindo image2.jpg (imagem já carregada)

---

### Explicação🤓

1. **Interface Image**: Define a interface que será implementada pela imagem real (`RealImage`) e pelo proxy (`ProxyImage`).
2. **RealImage**: É a classe que representa a imagem real, que tem o processo de carregamento demorado simulado pelo método `loadImageFromDisk()`.
3. **ProxyImage**: Controla o acesso à `RealImage`, carregando a imagem real apenas quando o método `display()` for chamado pela primeira vez.
4. **Application**: No código do cliente, ao chamar `display()`, a imagem real só é carregada na primeira vez em que é acessada, o que economiza recursos até que a imagem seja realmente necessária.

---

### Quando utilizar?🤔

**Proxy** é útil quando:
- Quando o **carregamento de um objeto é caro** em termos de tempo ou recursos, e você quer atrasar o carregamento até que o objeto seja necessário (lazy load).
- Quando você quer **controlar o acesso** a um objeto, por exemplo, para restringir o acesso com base em permissões.
- Para adicionar **comportamento adicional** a objetos existentes, sem modificar o código da classe original.

### Tipos de Proxy

- **Virtual proxy**: Adia a criação de objetos caros até que sejam necessários, como no exemplo de carregamento de imagens.
- **Protection proxy**: Controla o acesso a um objeto com base em permissões ou direitos de acesso.
- **Remote proxy**: Representa um objeto em um espaço de memória diferente, como em sistemas distribuídos.

---

### Utilização mundo real🌎

Exemplos práticos incluem:
- **Java RMI**: Usa proxies para chamadas de métodos em objetos remotos.
- **Biblioteca Java AWT (lazy loading)**: Na biblioteca AWT (Abstract Window Toolkit) do Java, o padrão Proxy é usado na classe Image para implementar o conceito de lazy loading.
- **Spring AOP**: AOP (Aspect-Oriented Programming) quando você define aspectos (como logging, segurança, ou transações) em torno de um método, o Spring cria um Proxy Dinâmico que intercepta as chamadas aos métodos da classe-alvo e aplica os aspectos antes ou depois da execução do método real.
- **Controle de Acesso**: Proxies podem validar permissões antes de permitir o acesso a métodos ou recursos. **Protection Proxy** pode verificar permissões antes de permitir que um usuário acesse um recurso ou método específico. Esse padrão é comum em aplicações que implementam controle de acesso baseado em regras (RBAC - Role-Based Access Control).

---

Em resumo, é utilizado para criar um substituto ou um placeholder para outro objeto. Ele é útil quando precisamos controlar o acesso a um objeto ou adicionar funcionalidades adicionais sem modificar o objeto real. Um proxy geralmente atua como intermediário, podendo controlar o acesso, carregar o objeto de forma preguiçosa(lazy load) ou aplicar outras funcionalidades.