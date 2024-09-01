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