package model;
public class Playlist {
    private static final int GENRES = 7;
    private static final int MAX_SONGS = 30;

    private String playlistName;
    private int playlistType;
    private Song[] songList;
    private int playlistLength;
    private Genre[] genres;
    
    public Playlist(String playlistName, int playlistType){
     this.playlistName = playlistName;
     this.playlistType = playlistType;
     playlistLength = 0;
     genres = new Genre[GENRES];
     songList= new Song[MAX_SONGS];
    }
    public String getPlaylistName(){
        return playlistName;
    }
    public void setPlaylistName(String playlistName){
        this.playlistName = playlistName;
    }
    public int getPlaylistType(){
        return playlistType;
    }
    public void setPlaylistNameType(int playlistType){
        this.playlistType = playlistType;
    }
    public int getPlaylistLength(){
        return playlistLength;
    }
    public void setPlaylistNameLength(int playlistLength){
        this.playlistLength = playlistLength;
    }
    public Genre[] getGenres(){
        return genres;
    }
    public Song[] getSongList(){
        return songList;
    }
    public void setSongList(Song song){
        boolean space = false;
        for(int i = 0; i<MAX_SONGS && !space;i++){
        this.songList[i] = song;
        space = true;
        }
        
    }
    public String showContents(){
        String contents = "************* Playlist **************\n";
        contents+= "** Title: "+ getPlaylistName() + "\n";
        contents+= "** Duration: "+ getPlaylistLength() + "\n";
        contents+= "** Genre: "+ getGenres() + "\n";
        contents+= "**********************************\n";
        return contents;
    }
}
