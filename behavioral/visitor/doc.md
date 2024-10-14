# Visitor

### Cenário de problema📊💰

Imagine que você está desenvolvendo um **sistema de contabilidade** que precisa calcular diferentes tipos de **tributos estaduais** sobre produtos, como **ICMS** (Imposto sobre Circulação de Mercadorias e Serviços), **COFINS** (Contribuição para o Financiamento da Seguridade Social) e **ISS** (Imposto sobre Serviços). Cada tipo de produto pode ter diferentes regras de tributação, e você deseja implementar a lógica de cálculo dos tributos sem modificar as classes de produtos.

Se você implementar o cálculo dos tributos diretamente nas classes de produtos, isso pode resultar em código duplicado e complicado de manter. Portanto, queremos uma abordagem que permita adicionar novos tipos de tributos ou produtos facilmente, sem modificar o código existente.

---

### Utilização do padrão✅

O padrão **Visitor** é ideal para esse cenário, pois permite que você defina uma nova operação (cálculo de tributos) sem alterar a estrutura das classes de produtos. Você pode criar visitantes que realizam os cálculos necessários para cada tipo de produto, mantendo a lógica de tributação separada das classes dos produtos.

---

### Exemplo em Java☕

Aqui está uma implementação do padrão **Visitor** para um sistema de contabilidade

```java
//1
public interface IProduct {
    void accept(IVisitor visitor);
}
```
1. Interface `IProduct`, que define o método `accept` para receber um visitante

```java
//1
public class Product implements IProduct {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
```
1. Implementação da classe `Product`, que aceita um visitante.

```java
//1
public interface IVisitor {
    void visit(Product product);
}
```
1. Interface `IVisitor`, que define métodos de visita para diferentes tipos de produtos.

```java
//1
public class ICMSCalculatorVisitor implements IVisitor {
    private static final Double ICMS_RATE = 0.18; // 18%

    @Override
    public void visit(Product product) {
        Double icms = product.getPrice() * ICMS_RATE;

        System.out.println("Calculando ICMS para o produto: " + product.getName() + " - ICMS: " + icms);
    }
}
```
1. Implementação do visitante `ICMSCalculatorVisitor`, que calcula o ICMS para produtos.

```java
//1
public class COFINSCalculatorVisitor implements IVisitor {
    private static final Double COFINS_RATE = 0.0765; // 7,65%

    @Override
    public void visit(Product product) {
        Double cofins = product.getPrice() * COFINS_RATE;

        System.out.println("Calculando COFINS para o produto: " + product.getName() + " - COFINS: " + cofins);
    }
}
```
1. Implementação do visitante `COFINSCalculatorVisitor`, que calcula o COFINS para produtos.

```java
//1
public class ISSCalculatorVisitor implements IVisitor {
    private static final Double ISS_RATE = 0.05; // 5%

    @Override
    public void visit(Product product) {
        Double iss = product.getPrice() * ISS_RATE;

        System.out.println("Calculando ISS para o serviço: " + product.getName() + " - ISS: " + iss);
    }
}
```
1. Implementação do visitante `ISSCalculatorVisitor`, que calcula o ISS para produtos.

### Utilizando o padrão:

```java
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<IProduct> products = new ArrayList<>();
        IProduct service = new Product("Frete municipal - Pedido#234653", 95.00);
        
        products.add(new Product("Placa de Vídeo RTX 4060 VENTUS", 1945.99));
        products.add(new Product("Fonte MSI MAG A650BN, 650W, 80 Plus Bronze", 294.99));
        products.add(new Product("Mouse Gamer HyperX Pulsefire Core RGB 6200 DPI", 149.99));

        IVisitor icmsCalculator = new ICMSCalculatorVisitor();
        IVisitor cofinsCalculator = new COFINSCalculatorVisitor();
        IVisitor issCalculator = new ISSCalculatorVisitor();

        //1
        for (IProduct product : products) {
            product.accept(icmsCalculator);
        }

        System.out.println();

        //2
        for (IProduct product : products) {
            product.accept(cofinsCalculator);
        }

        System.out.println();

        //3
        service.accept(issCalculator);
    }
}
```
1. Calculando ICMS
2. Calculando COFINS
3. Calculando ISS

---

### Explicação🤓

- **Interface `IProduct`:** Define o método `accept`, que permite que um visitante realize operações sobre o produto.
- **Classe `Product`:** Implementa a interface `IProduct` e aceita visitantes, permitindo que eles executem operações específicas para calcular tributos.
- **Interface `IVisitor`:** Define os métodos que os visitantes devem implementar para operar sobre os diferentes tipos de produtos.
- **Classes `ICMSCalculatorVisitor`, `COFINSCalculatorVisitor` e `ISSCalculatorVisitor`:** Implementam a lógica específica para calcular o ICMS, COFINS e ISS, respectivamente, sem modificar a classe `Product`.

---

### Quando utilizar?🤔

Use o padrão **Visitor** quando:
- Você deseja adicionar operações a uma estrutura de objetos sem modificar suas classes.
- Você tem uma estrutura de objetos complexa e precisa aplicar operações diferentes a diferentes tipos de objetos.
- O número de operações que podem ser aplicadas a uma estrutura de objetos varia, enquanto o número de classes de objetos permanece constante.

---

### Utilização no mundo real🌎

- **Sistemas de compiladores:** Usado para implementar várias operações, como análise sintática e semântica em árvores de sintaxe abstrata.
- **Sistemas de banco de dados:** Permite operações como exportação e importação de diferentes tipos de dados sem modificar a estrutura do banco de dados.
- **Ferramentas de design de interfaces:** Permite a aplicação de operações diferentes em componentes de interface gráfica, como estilos e animações.
- **Frameworks de relatórios:** Aplicações que precisam gerar relatórios diferentes (PDF, Excel) a partir de um conjunto de dados comum.
- **Analisadores de documentos:** Para analisar e processar documentos com diferentes formatos (PDF, Word, texto) sem alterar a lógica dos tipos de documentos.