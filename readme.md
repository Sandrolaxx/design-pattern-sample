# Design Patterns

## O que são?

Design Patterns (ou padrões de design) são soluções típicas para problemas recorrentes no desenvolvimento de software. Eles representam boas práticas adotadas por desenvolvedores experientes e foram criados para facilitar a manutenção, escalabilidade e a clareza do código.

Padrões não são trechos de códigos específicos, mas sim um conceito geral para resolver problemas específicos, assim você precisa seguir o pattern e adaptar ao seu problema baseado na realidade do seu software.

## Breve história

Padrões de design de software orientado a objetos foi publicado em 1995 por Erich Gamma, John Vlissides, Ralph Johnson e Richard Helm no livro “Design Patterns: Elements of Reusable Object-Oriented Software”, onde foram catalogados 23 padrões que resolviam vários problemas de design orientado a objetos, o livro se tornou um best-seller muito rapidamente. Devido ao seu nome ser muito extenso o livro foi batizado de GoF (Gang of Four).

## Por que usar Design Patterns?

* Reutilização: Design patterns promovem a reutilização de soluções testadas, evitando a necessidade de "reinventar a roda" e economizando tempo durante o desenvolvimento.

* Manutenção e flexibilidade: O uso de padrões facilita a manutenção do código, pois as soluções são reconhecíveis e compreendidas por desenvolvedores familiarizados com os padrões.

* Comunicação Eficiente: Ao usar design patterns, desenvolvedores podem se comunicar de maneira mais eficiente, referindo-se a uma solução complexa com um nome simples e amplamente compreendido, como "Factory Method" ou "Observer".

* Escalabilidade: Muitos design patterns ajudam a criar sistemas que podem ser facilmente estendidos ou modificados à medida que novos requisitos surgem.

---

## Abaixo temos todos os padrões, divididos em suas três categorias:

> Clique no nome para mais informações e exemplos de código*

### Padrões criacionais

* [Singleton](/creatinonal/singleton/doc.md): Garante que uma classe tenha apenas uma instância e fornece um ponto global de acesso a ela.
* [Abstract Factory](/creatinonal/abstractfactory/doc.md): Fornece uma interface para criar famílias de objetos relacionados ou dependentes sem especificar suas classes concretas.
* [Factory Method](/creatinonal/factorymethod/doc.md): Define uma interface para criar um objeto, mas permite que as subclasses alterem o tipo de objeto que será criado.
* [Prototype](/creatinonal/prototype/doc.md): Permite a criação de novos objetos copiando uma instância existente.
* [Builder](/creatinonal/builder/doc.md): Separa a construção de um objeto complexo da sua representação, permitindo a criação de diferentes representações.

### Padrões estruturais

* [Adapter](/structural/adapter/doc.md): Permite que interfaces incompatíveis trabalhem juntas, convertendo a interface de uma classe em outra interface que o cliente espera.
* [Bridge](/structural/bridge/doc.md): Separa a abstração da implementação, permitindo que ambas evoluam independentemente, facilitando a adição de novas abstrações e implementações.
* [Composite](/structural/composite/doc.md): Permite compor objetos em estruturas de árvore para representar hierarquias parte-todo, permitindo que os clientes tratem objetos individuais e composições de forma uniforme.
* [Decorator](/structural/decorator/doc.md): Adiciona responsabilidades adicionais a um objeto dinamicamente, permitindo que funcionalidades sejam estendidas sem modificar a classe original.
* [Facade](/structural/facade/doc.md): Fornece uma interface simplificada para um conjunto de interfaces em um subsistema, facilitando o uso desse subsistema por clientes.
* [Flyweight](/structural/flyweight/doc.md): Permite a compartilhamento eficiente de objetos para suportar um grande número de objetos de granulação fina, reduzindo o uso de memória.
* [Proxy](/structural/proxy/doc.md): Fornece um objeto substituto que controla o acesso a outro objeto, permitindo que operações adicionais sejam realizadas quando o objeto real é acessado.

### Padrões comportamentais

* [Chain of Responsibility](/behavioral/chainofresponsibility/doc.md): Permite que múltiplos objetos processem uma solicitação, passando a solicitação ao longo da cadeia de manipuladores até que um deles a trate.
* [Command](/behavioral/command/doc.md): Encapsula uma solicitação como um objeto, permitindo que você parametrize clientes com filas, solicitações ou operações que podem ser desfeitas.
* [Interpreter](/behavioral/interpreter/doc.md): Define uma representação gramatical para uma linguagem e fornece um interpretador para essa linguagem, permitindo que expressões sejam avaliadas.
* [Iterator](/behavioral/iterator/doc.md): Fornece uma maneira de acessar os elementos de uma coleção de objetos sequencialmente, sem expor a representação subjacente da coleção.
* [Mediator](/behavioral/mediator/doc.md): Define um objeto que encapsula a interação entre um conjunto de objetos, promovendo o desacoplamento ao evitar referências diretas entre os objetos.
* [Memento](/behavioral/memento/doc.md): Permite que o estado de um objeto seja salvo e restaurado sem expor sua implementação, possibilitando desfazer e refazer operações.
* [Observer](/behavioral/observer/doc.md): Define uma dependência de um-para-muitos entre objetos, de modo que quando um objeto muda de estado, todos os seus dependentes são notificados e atualizados automaticamente.
* [State](/behavioral/state/doc.md): Permite que um objeto altere seu comportamento quando seu estado interno muda, parecendo que o objeto mudou sua classe.
* [Strategy](/behavioral/strategy/doc.md): Define uma família de algoritmos, encapsula cada um deles e os torna intercambiáveis, permitindo que o algoritmo varie independentemente dos clientes que o utilizam.
* [Template Method](/behavioral/templatemethod/doc.md): Define o esqueleto de um algoritmo em uma operação, adiando algumas etapas para subclasses, permitindo que subclasses redefinam certos passos do algoritmo sem mudar sua estrutura. 
* [Visitor](/behavioral/visitor/doc.md): Permite que você adicione novas operações a uma estrutura de objetos sem modificar os objetos, definindo uma nova operação na classe visitante.