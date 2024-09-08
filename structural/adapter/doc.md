# Adapter

### Cenário do problema🔌🇧🇷🇬🇧

Imagine que você está fazendo um intercambio para o Reino Unido, chegando lá com seu laptop, você descobre que o padrão de tomada é diferente. Seu carregador foi projetado para funcionar com uma tomada de dois pinos (padrão BR), mas lá são utilizadas tomadas de três pinos (padrão UK). Para resolver esse problema sem a necessidade de modificar o design do carregador ou da tomada, você pode usar um adaptador de tomada que faz a conversão entre esses dois padrões.

---

### Utilização do padrão✅

Nesse cenário, o **Adapter** pode ser usado para adaptar um carregador com pinos brasileiros a uma tomada britânica.

---

### Exemplo em Java☕

```java
//1
interface IUKPlug {
    void connectToUnitedKingdomSocket();
}
```
1. Interface que define o padrão de tomada esperado(UK)

```java
//1
class BRPlug {
    public void connectToBrazilianSocket() {
        System.out.println("Conectado a uma tomada do brasil (dois pinos).🔌🇧🇷");
    }
}
```
1. Classe que representa o tipo de plug e conexão com a tomada do BR

```java

//1
class PlugAdapter implements IUKPlug {

    private BRPlug brPlug;

    public PlugAdapter(BRPlug brPlug) {
        this.brPlug = brPlug;
    }

    @Override
    public void connectToUnitedKingdomSocket() {
        //2
        System.out.println("Usando um adaptador de tomada...🔄");

        brPlug.connectToBrazilianSocket();
    }

}
```
1. Adapter que adapta a tomada UK para o padrão BR
2. Adapta para a tomada UK

### Utilizando Adapter

Aqui está um exemplo de utilização do padrão e de como adaptar o contrato de uma interface:

```java
//1
public class Application {
    public static void main(String[] args) {
        //2
        BRPlug brazilianPlug = new BRPlug();

        //3
        IUKPlug unitedKingdomPlug = new PlugAdapter(brazilianPlug);

        //4
        unitedKingdomPlug.connectToUnitedKingdomSocket();
    }
}
```
1. Cliente que espera uma tomada do Reino Unido (três pinos)
2. Plug do Brasil
3. Adaptador para que o plugue brasileiro possa se conectar a uma tomada do Reino Unido
4. Conectar o plugue BR (adaptado) a uma tomada do Reino Unido

---

### Explicação🤓

- **Integração de componentes incompatíveis**: O Adapter é usado quando você precisa integrar dois componentes com interfaces incompatíveis, como uma tomada de dois pinos (BR) em um sistema que espera uma tomada de três pinos (UK).
- **Reutilização de componentes existentes**: Permite que o carregador existente (BR) seja reutilizado sem precisar ser modificado para trabalhar com tomadas britânicas.
- **Isolamento de mudanças**: O padrão evita que você tenha que modificar os componentes originais (carregador ou tomada), isolando a adaptação no próprio adaptador.

---

### Quando utilizar?🤔

Adapter é útil quando:
- Classes ou sistemas têm interfaces incompatíveis.
- É necessário integrar bibliotecas ou APIs de terceiros.
- Você deseja reutilizar código legado sem o modificar.
- Precisa padronizar múltiplos formatos ou protocolos.
- É necessário converter tipos ou unidades entre sistemas.

**Adapter** é um padrão de design estrutural que permite que interfaces incompatíveis trabalhem juntas. Ele envolve a criação de um "adaptador" que converte a interface de uma classe em outra interface esperada pelo cliente, permitindo que classes com interfaces incompatíveis possam se comunicar.