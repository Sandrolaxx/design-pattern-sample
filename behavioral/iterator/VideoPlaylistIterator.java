package behavioral.iterator;

public class VideoPlaylistIterator implements Iterator<Video> {

    private Video[] videos;
    
    private int position = 0;

    public VideoPlaylistIterator(Video[] videos) {
        this.videos = videos;
    }

    @Override
    public boolean hasNext() {
        return position < videos.length && videos[position] != null;
    }

    @Override
    public Video next() {
        return videos[position++];
    }
    
}
