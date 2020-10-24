package model;
public class Song {
    private String title;
    private String artistName;
    private String streamingDate;
    private int songLength;
    private Genre genre;
    private String songOwner;
    private String ownerPassword;

    public Song(String title, String artistName, String streamingDate, int songLength, Genre genre,String songOwner,String ownwerPassword){
    this.title = title;
    this.artistName = artistName;
    this.streamingDate = streamingDate;
    this.songLength = songLength;
    this.genre = genre;
    this.songOwner = songOwner;
    this.ownerPassword = ownwerPassword;
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
    public int getSongLength(){
        return songLength;
    }
    public void setSongLength(int songLength){
        this.songLength = songLength;
    }
    public Genre getSongGenre(){
        return genre;
    }
    public void setSongGenre(Genre genre){
        this.genre= genre;
    }
    public String getSongOwner(){
        return songOwner;
    }
    public void setSongOwner(String songOwner){
        this.songOwner = songOwner;
    }
    public String getOwnerPassword(){
        return ownerPassword;
    }
    public void setOwnerPassword(String ownerPassword){
        this.ownerPassword = ownerPassword;
    }
    public String formatLength(int songLength){
        int hours = (int)(songLength/3600);
        int minutes = (int)((songLength-hours*3600)/60);
        int seconds = (int)(songLength-(hours*3600+minutes*60));
        String format = (hours + " horas " + minutes +" minutos " + seconds + " segundos ");
        return format;
    }
    public String showContents(){
        String contents = "************* Song **************\n";
        contents+= "** Title: "+ getTitle() + "\n";
        contents+= "** Artist: "+ getArtistName() + "\n";
        contents+= "** Duration: "+ formatLength(getSongLength()) + "\n";
        contents+= "** Genre: "+ getSongGenre() + "\n";
        contents+= "**********************************";
        return contents;
    }
}
