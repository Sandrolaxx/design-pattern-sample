package behavioral.iterator;

public class Application {
    public static void main(String[] args) {

        VideoPlaylist playlist = new VideoPlaylist(5);
        
        playlist.addVideo(new Video("Filme 1"));
        playlist.addVideo(new Video("Série 1 - Episódio 1"));
        playlist.addVideo(new Video("Filme 2"));

        Iterator<Video> iterator = playlist.createIterator();

        while (iterator.hasNext()) {
            Video video = iterator.next();
            
            System.out.println("Reproduzindo: " + video.getName());
        }

    }
}
