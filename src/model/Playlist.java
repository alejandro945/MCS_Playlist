package model;
public class Playlist {
    private static final int GENRES = 7;

    private String playlistName;
    private int playlistLength;
    private Genre[] genres;
    
    public Playlist(String playlistName){
     this.playlistName = playlistName;
     playlistLength = 0;
     genres = new Genre[GENRES];
    }
}
