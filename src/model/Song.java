package model;
public class Song {
    private String title;
    private String artistName;
    private String streamingDate;
    private Time songLength;
    private Genre genre;
    public Song(String title, String artistName, String streamingDate, int songLength, Genre genre,String userNickName,String password){
    this.title = title;
    this.artistName = artistName;
    this.streamingDate = streamingDate;
    this.songLength = songLength;
    this.genre = genre;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getArtistName(){
        return artistName;
    }
    public void setArtistName(String artistName){
        this.artistName = artistName;
    }
    public String getStreamingDate(){
        return streamingDate;
    }
    public void setStreamingDate(String streamingDate){
        this.streamingDate = streamingDate;
    }
    
}
