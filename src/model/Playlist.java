package model;

public class Playlist {
    private String playlistName;
    private Time playlistLength;
    private String[] songGenre;
    public Playlist(String playlistName){
     this.playlistName = playlistName;
      playlistLength = 0;
    }
}
