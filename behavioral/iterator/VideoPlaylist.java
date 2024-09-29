package behavioral.iterator;

public class VideoPlaylist implements Playlist {
    
    private Video[] videos;
    
    private int size;

    public VideoPlaylist(int size) {
        this.videos = new Video[size];
        this.size = 0;
    }

    public void addVideo(Video video) {
        if (size < videos.length) {
            videos[size] = video;
            size++;
        }
    }

    @Override
    public Iterator<Video> createIterator() {
        return new VideoPlaylistIterator(videos);
    }

}
