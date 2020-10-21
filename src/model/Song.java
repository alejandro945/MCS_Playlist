package model;
public class Song {
    private String title;
    private String artistName;
    private String streamingDate;
    private Time songLength;
    private Genre genre;
    public Song(String title, String artistName, String streamingDate, Time songLength, Genre genre){
    this.title = title;
    this.artistName = artistName;
    this.streamingDate = streamingDate;
    this.songLength = songLength;
    this.genre = genre;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(){
        this.title = title;
    }
}
