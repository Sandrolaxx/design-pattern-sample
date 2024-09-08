# Abstract Factory

### Cenário de problema🌞🌛

Imagine que você está desenvolvendo uma aplicação de interface gráfica que precisa suportar diferentes temas visuais, como um tema claro e um tema escuro. Cada tema possui seu próprio conjunto de componentes de interface, como botões, caixas de texto e janelas, que precisam ser estilizados de acordo com o tema selecionado.

Se você implementar a criação desses componentes diretamente no código da interface, isso resultará em um código altamente acoplado, difícil de manter e estender. Além disso, a mudança de tema se tornaria uma tarefa complexa, pois exigiria modificações em várias partes do código.

---

### Utilização do padrão✅

O padrão **Abstract Factory** é ideal para este cenário porque permite a criação de famílias de objetos relacionados (como os componentes de um tema) sem especificar suas classes concretas. Ele fornece uma interface para criar diferentes famílias de objetos, permitindo que você altere a família de objetos criada simplesmente mudando a factory usada, sem precisar alterar o código que utiliza esses objetos.

---

### Exemplo em Java☕

Aqui está um exemplo da implementação de Abstract Factory em Java:

```java
// 1
public interface IButton {
    void render();
}
```

1. Interface para contrato do botão

```java
// 1
public interface ITextBox {
    void render();
}
```

1. Interface para contrato do caixa de texto

```java
// 1
public class LightButton implements IButton {
    @Override
    public void render() {
        System.out.println("Btn em light mode🌞");
    }
}
```

1. Implementação de botão para tema claro

```java
public class LightTextBox implements ITextBox {
    @Override
    public void render() {
        System.out.println("Caixa de texto em light mode🌞");
    }
}
```

1. Implementação de caixa de texto para tema claro

```java
// 1
public class DarkButton implements IButton {
    @Override
    public void render() {
        System.out.println("Btn em dark mode🌛");
    }
}
```

1. Implementação de botão para tema escuro

```java
//1
public class DarkTextBox implements ITextBox {
    @Override
    public void render() {
        System.out.println("Caixa de texto em dark mode🌛");
    }
}
```

1. Implementação de caixa de texto para tema escuro

```java
// 
public interface IGUIFactory {
    IButton createButton();
    ITextBox createTextBox();
}
```

1. Interface para a Abstract Factory

```java
//1
public class LightThemeFactory implements IGUIFactory {
    @Override
    public IButton createButton() {
        return new LightButton();
    }

    @Override
    public ITextBox createTextBox() {
        return new LightTextBox();
    }
}
```

1. Implementação da Factory para tema claro

```java
//1
public class DarkThemeFactory implements IGUIFactory {
    @Override
    public IButton createButton() {
        return new DarkButton();
    }

    @Override
    public ITextBox createTextBox() {
        return new DarkTextBox();
    }
}
```

1. Implementação da Factory para tema escuro

### Utilizando Abstract Factory

Aqui está um exemplo de utilização do padrão e de como alternar entre tema claro e escuro na interface gráfica:

```java
public class Application {
    private IButton iButton;
    private ITextBox iTextBox;

    public Application(IGUIFactory factory) {
        //1
        iButton = factory.createButton();
        iTextBox = factory.createTextBox();
    }

    public void render() {
        //2
        iButton.render();
        iTextBox.render();
    }

    public static void main(String[] args) {
        //3
        IGUIFactory factory;

        String theme = "dark";

        if (theme.equals("light")) {
            factory = new LightThemeFactory();
        } else {
            factory = new DarkThemeFactory();
        }

        //4
        Application app = new Application(factory);
        app.render();
    }
}
```

1. Criação dos componentes usando a factory recebida
2. Renderização dos componentes
3. Selecionando o tema desejado
4. Criação da aplicação com o tema selecionado

---

### Explicação🤓

- **Interface `IGUIFactory`:** Define os métodos para criar os objetos relacionados, como `createButton()` e `createTextBox()`. Isso permite a criação de diferentes famílias de objetos (temas) sem especificar suas classes concretas.

- **Classes concretas de componentes (`LightButton`, `DarkButton`, `LightTextBox`, `DarkTextBox`):** Implementam as interfaces `IButton` e `ITextBox`, representando diferentes estilos de componentes para temas claros e escuros.

- **Classes concretas de factory (`LightThemeFactory`, `DarkThemeFactory`):** Implementam a interface `IGUIFactory` para criar os componentes específicos do tema claro e do tema escuro.

- **Aplicação (`Application`):** Recebe uma instância de `IGUIFactory` e a utiliza para criar e renderizar os componentes. A factory concreta passada para a aplicação determina quais versões dos componentes (claro ou escuro) serão criadas.

---

### Quando utilizar?🤔

Abstract Factory é útil quando:
- Você precisa criar famílias de objetos relacionados ou dependentes sem especificar suas classes concretas.
- A família de objetos precisa ser facilmente substituível ou configurável, como no caso de temas de interface gráfica.
- Você deseja que o sistema seja facilmente extensível para suportar novas famílias de objetos (como adicionar novos temas no futuro) sem modificar o código existente.

Esse padrão é frequentemente usado em bibliotecas de interface gráfica, sistemas de plug-ins, e frameworks onde é necessário fornecer um conjunto de funcionalidades relacionadas, mantendo a flexibilidade para mudanças e expansões futuras.