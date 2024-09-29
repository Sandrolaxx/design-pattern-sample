# Iterator

### Cenário de problema🌞🌛

Imagine que você está desenvolvendo uma plataforma de streaming de vídeo. Nessa plataforma, os usuários podem criar listas de reprodução (playlists) com filmes e séries. Cada playlist pode conter diferentes tipos de conteúdo, como episódios de séries ou filmes completos.

O problema surge quando você precisa implementar a navegação por essas listas de reprodução. É necessário permitir que os usuários percorram suas playlists de maneira eficiente e consistente, independentemente do tipo de conteúdo (filmes ou séries). Implementar essa navegação diretamente no código da playlist pode torná-lo rígido e difícil de estender, especialmente se no futuro for necessário adicionar novos tipos de conteúdo ou diferentes formas de percorrer a lista (por exemplo, de trás para frente).

---

### Utilização do padrão✅

O padrão **Iterator** é ideal para este cenário porque permite acessar os elementos de um conjunto de objetos (no caso, a playlist) sequencialmente, sem expor sua implementação interna. Ele separa a responsabilidade de percorrer a coleção da própria coleção, permitindo que diferentes tipos de iteração sejam implementados de forma flexível e extensível.

---

### Exemplo em Java☕

Aqui está um exemplo da implementação do padrão Iterator em Java para navegar por uma playlist de vídeos:

```java
// 1
public interface Iterator<T> {
    boolean hasNext();
    T next();
}
```

1. Interface **Iterator** define os métodos principais para iteração: `hasNext()` para verificar se há mais elementos e `next()` para obter o próximo elemento.

```java
// 1
public interface Playlist {
    Iterator<Video> createIterator();
}
```

1. Interface **Playlist** define o método para criar um iterador específico para a lista de reprodução.

```java
// 1
public class Video {
    private String nome;

    public Video(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
```

1. Classe **Video** representa o conteúdo de vídeo (filmes, séries, etc.).

```java
// 1
public class VideoPlaylist implements Playlist {
    private Video[] videos;
    private int tamanho;

    public VideoPlaylist(int tamanho) {
        this.videos = new Video[tamanho];
        this.tamanho = 0;
    }

    public void addVideo(Video video) {
        if (tamanho < videos.length) {
            videos[tamanho] = video;
            tamanho++;
        }
    }

    @Override
    public Iterator<Video> createIterator() {
        return new VideoPlaylistIterator(videos);
    }
}
```

1. Classe **VideoPlaylist** representa a coleção de vídeos. Ela armazena uma lista de vídeos e cria um iterador para percorrê-la.

```java
// 1
public class VideoPlaylistIterator implements Iterator<Video> {
    private Video[] videos;
    private int posicao = 0;

    public VideoPlaylistIterator(Video[] videos) {
        this.videos = videos;
    }

    @Override
    public boolean hasNext() {
        return posicao < videos.length && videos[posicao] != null;
    }

    @Override
    public Video next() {
        return videos[posicao++];
    }
}
```

1. Classe **VideoPlaylistIterator** implementa o comportamento de iteração para a playlist de vídeos.

---

### Utilizando Iterator

Aqui está como você pode usar o padrão Iterator para navegar por uma playlist de vídeos.

```java
public class StreamingApp {
    public static void main(String[] args) {
        //1
        VideoPlaylist playlist = new VideoPlaylist(5);
        playlist.addVideo(new Video("Filme 1"));
        playlist.addVideo(new Video("Série 1 - Episódio 1"));
        playlist.addVideo(new Video("Filme 2"));

        //2
        Iterator<Video> iterator = playlist.createIterator();

        //3
        while (iterator.hasNext()) {
            Video video = iterator.next();
            System.out.println("Reproduzindo: " + video.getNome());
        }
    }
}
```

1. Criamos uma playlist de vídeos e adicionamos alguns conteúdos (filmes e episódios de séries).
2. Criamos o iterador para percorrer a playlist.
3. Usamos o iterador para acessar e reproduzir cada vídeo da lista.

---

### Explicação🤓

- **Interface `Iterator`:** Define os métodos que permitem percorrer a coleção sem expor sua implementação interna.
- **Classe `VideoPlaylistIterator`:** Implementa a lógica de iteração específica para a coleção de vídeos.
- **Interface `Playlist`:** Define um método para criar o iterador. A playlist em si não precisa expor sua estrutura interna.
- **Classe `VideoPlaylist`:** Implementa a coleção de vídeos e fornece o iterador para percorrer a playlist.

---

### Quando utilizar?🤔

O padrão **Iterator** é útil quando:
- Você precisa percorrer diferentes coleções de objetos de maneira uniforme, independentemente da implementação dessas coleções.
- Deseja separar a lógica de iteração da própria estrutura de dados, facilitando a manutenção e a extensão.
- A estrutura interna da coleção deve permanecer encapsulada, mas você ainda precisa fornecer uma maneira de percorrê-la.

---

### Utilização mundo real🌎

- **Java Collections Framework:** O padrão Iterator é amplamente utilizado em coleções como `ArrayList`, `HashSet`, e `LinkedList` para permitir que os usuários percorram os elementos dessas coleções sem expor sua implementação interna.
- **Sistemas de armazenamento de dados:** Em bancos de dados ou sistemas de arquivos, os iteradores são usados para percorrer conjuntos de resultados ou listas de arquivos.
- **Interfaces de usuário:** Componentes de UI que exibem listas ou grades de elementos frequentemente usam iteradores para percorrer e exibir os itens de forma consistente.

---

Este padrão é fundamental para permitir iterações flexíveis em coleções sem precisar saber como elas estão estruturadas internamente.