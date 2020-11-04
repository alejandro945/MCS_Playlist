package model;
public class Song {
    private String title;
    private String artistName;
    private String streamingDate;
    private int songLength;
    private Genre genre;
    private String songOwner;
    private String ownerPassword;

    public Song(String title, String artistName, String streamingDate, int songLength, Genre genre,String songOwner,String ownerPassword){
    this.title = title;
    this.artistName = artistName;
    this.streamingDate = streamingDate;
    this.songLength = songLength;
    this.genre = genre;
    this.songOwner = songOwner;
    this.ownerPassword = ownerPassword;
    }
    
    /** 
     * @return String
     */
    public String getTitle(){
        return title;
    }
    
    /** 
     * @param title
     */
    public void setTitle(String title){
        this.title = title;
    }
    
    /** 
     * @return String
     */
    public String getArtistName(){
        return artistName;
    }
    
    /** 
     * @param artistName
     */
    public void setArtistName(String artistName){
        this.artistName = artistName;
    }
    
    /** 
     * @return String
     */
    public String getStreamingDate(){
        return streamingDate;
    }
    
    /** 
     * @param streamingDate
     */
    public void setStreamingDate(String streamingDate){
        this.streamingDate = streamingDate;
    }
    
    /** 
     * @return int
     */
    public int getSongLength(){
        return songLength;
    }
    
    /** 
     * @param songLength
     */
    public void setSongLength(int songLength){
        this.songLength = songLength;
    }
    
    /** 
     * @return Genre
     */
    public Genre getSongGenre(){
        return genre;
    }
    
    /** 
     * @param genre
     */
    public void setSongGenre(Genre genre){
        this.genre= genre;
    }
    
    /** 
     * @return String
     */
    public String getSongOwner(){
        return songOwner;
    }
    
    /** 
     * @param songOwner
     */
    public void setSongOwner(String songOwner){
        this.songOwner = songOwner;
    }
    
    /** 
     * @return String
     */
    public String getOwnerPassword(){
        return ownerPassword;
    }
    
    /** 
     * @param ownerPassword
     */
    public void setOwnerPassword(String ownerPassword){
        this.ownerPassword = ownerPassword;
    }
    
    /** 
     * @param songLength
     * @return String
     */
    public String formatLength(int songLength){
        int hours = (int)(songLength/3600);
        int minutes = (int)((songLength-hours*3600)/60);
        int seconds = (int)(songLength-(hours*3600+minutes*60));
        String format = (hours + " horas " + minutes +" minutos " + seconds + " segundos ");
        return format;
    }
    
    /** 
     * @return String
     */
    public String showContents(){
        String contents = "************* Song **************\n";
        contents+= "** Title: "+ getTitle() + "\n";
        contents+= "** Artist: "+ getArtistName() + "\n";
        contents+= "** Duration: "+ formatLength(getSongLength()) + "\n";
        contents+= "** Genre: "+ getSongGenre() + "\n";
        contents+= "**********************************\n";
        return contents;
    }
}
