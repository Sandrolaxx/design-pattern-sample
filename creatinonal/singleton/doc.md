# Singleton

### Cenário de problema🎰

Imagine que você está desenvolvendo um sistema de cassino online, onde é necessário acessar um recurso de log centralizado para registrar todas as operações críticas, como transações, apostas e excpetions. Esse recurso de log deve ser único e globalmente acessível para garantir que todos os registros sejam armazenados de forma consistente e que não haja múltiplas instâncias concorrendo pelos recursos do sistema, o que poderia resultar em dados inconsistentes.

---

### Utilização do padrão✅

O **padrão Singleton** é ideal para este cenário porque garante que o sistema tenha apenas uma instância do objeto de log, fornecendo um ponto global de acesso a essa instância. Dessa forma, todas as partes do sistema podem compartilhar e usar a mesma instância, garantindo a consistência dos registros.

---

### Exemplo em Java☕

Aqui está um exemplo de como implementar o padrão Singleton em Java:

```java
public class Logger {
    //1
    private static Logger instance;

    //2
    private Logger() {
        //3
        System.out.println("Logger inicializado.");
    }

    //4
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }

        return instance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
```

1. Atributo estático que irá manter a referência à instância única.
2. Construtor privado para impedir que a classe seja instanciada diretamente.
3. Configurações iniciais de log, se necessário.
4. Aqui acontece a magia, esse método público estático controla o acesso à instância única.

### Utilizando nossa classe

No sistema cassino, você pode usar a classe `Logger`:

```java
public class TigersSystem {
    public static void main(String[] args) {
        //1
        Logger logger = Logger.getInstance();
        
        try {
            handleBet(1000d);
        } catch(Exception ex) {
            //2
            logger.log("Erro ao realizar transação: " + ex);
        }
    }

}
```

1. Acessando o logger através do método getInstance.
2. Gerando log através do do metódo log.

---

### Explicação🤓

- **Instância única:** A classe `Logger` tem uma instância única (`instance`), que é criada apenas quando o método `getInstance()` é chamado pela primeira vez. Isso assegura que todos os logs do sistema sejam feitos pela mesma instância do Logger, evitando problemas como concorrência de threads ou inconsistência de dados.

- **Construtor privado:** O construtor da classe `Logger` é privado, o que impede que outras classes criem novas instâncias do `Logger`. Isso força o uso do método `getInstance()` para obter a única instância disponível.

- **Método síncrono:** O método `getInstance()` é sincronizado (`synchronized`) para garantir que, em um ambiente multi-thread, apenas uma thread possa criar a instância Singleton, evitando a criação de múltiplas instâncias acidentalmente.

---

### Quando utilizar?🤔

Singleton é útil em cenários onde:
- Apenas uma instância de uma classe deve existir.
- A instância deve ser acessível globalmente.
- É importante controlar o acesso ao recurso compartilhado para evitar problemas de concorrência.

---

### Utilização mundo real🌎

- **Java Runtime Environment (JRE)**: Classe `Runtime` fornece um ponto de acesso global para a instância atual da máquina virtual Java e permite interagir com o ambiente de execução (como obter a memória livre, executar comandos, etc.). A instância é acessada através do método Runtime.getRuntime().
- **Java Logging API**: A classe `Logger` da API de logging (java.util.logging) é usada como um Singleton para garantir que há uma única instância de logger para uma determinada configuração.
- **Spring Framework**: Padrão é usado para gerenciar beans com escopo Singleton. O contexto da aplicação (`ApplicationContext`) gerencia essas instâncias de beans, garantindo que apenas uma instância de cada bean seja criada e usada ao longo da vida útil da aplicação.

---

Exemplos incluem gerenciamento de configurações globais, acesso a recursos compartilhados (como loggers ou conexão com banco de dados), e implementação de caches globais.