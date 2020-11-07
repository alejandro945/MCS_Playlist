package model;

public class Song {
    private String title;
    private String artistName;
    private String streamingDate;
    private int songLength;
    private Genre genre;
    private String songOwner;
    private String ownerPassword;

    /**
     * The constructor method of a song Object<br>
     */
    public Song(String title, String artistName, String streamingDate, int songLength, Genre genre, String songOwner,
            String ownerPassword) {
        this.title = title;
        this.artistName = artistName;
        this.streamingDate = streamingDate;
        this.songLength = songLength;
        this.genre = genre;
        this.songOwner = songOwner;
        this.ownerPassword = ownerPassword;
    }

    /**
     * Gets the title of the song <br>
     * 
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the song <br>
     * 
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the Artist or band name of the song <br>
     * 
     * @return artistName
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     * Sets the Artist or band name of the song <br>
     * 
     * @param artistName
     */
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    /**
     * Gets the streaming date of the song <br>
     * 
     * @return streamingDate
     */
    public String getStreamingDate() {
        return streamingDate;
    }

    /**
     * Sets the streaming date of the song <br>
     * 
     * @param streamingDate
     */
    public void setStreamingDate(String streamingDate) {
        this.streamingDate = streamingDate;
    }

    /**
     * Gets the length of the song <br>
     * 
     * @return songLength
     */
    public int getSongLength() {
        return songLength;
    }

    /**
     * Sets the length of the song <br>
     * 
     * @param songLength
     */
    public void setSongLength(int songLength) {
        this.songLength = songLength;
    }

    /**
     * Gets the genre of the song <br>
     * 
     * @return genre
     */
    public Genre getSongGenre() {
        return genre;
    }

    /**
     * Sets the genre of the song <br>
     * 
     * @param genre
     */
    public void setSongGenre(Genre genre) {
        this.genre = genre;
    }

    /**
     * Gets the owner or user that have created the song <br>
     * 
     * @return songOwer
     */
    public String getSongOwner() {
        return songOwner;
    }

    /**
     * Sets the owner or user that have created the song <br>
     * 
     * @param songOwner
     */
    public void setSongOwner(String songOwner) {
        this.songOwner = songOwner;
    }

    /**
     * Gets the password of user that have created the song <br>
     * 
     * @return ownerPassword
     */
    public String getOwnerPassword() {
        return ownerPassword;
    }

    /**
     * Sets the password of user that have created the song <br>
     * 
     * @param ownerPassword
     */
    public void setOwnerPassword(String ownerPassword) {
        this.ownerPassword = ownerPassword;
    }

    /**
     * Converts an irrelevant number of seconds into the set format or relevant
     * requirement <br>
     * 
     * @param songLength != String for the prevention of possible errors
     * @return format
     */
    public String formatLength(int songLength) {
        int hours = (int) (songLength / 3600);
        int minutes = (int) ((songLength - hours * 3600) / 60);
        int seconds = (int) (songLength - (hours * 3600 + minutes * 60));
        String format = (hours + " horas " + minutes + " minutos " + seconds + " segundos ");
        return format;
    }

    /**
     * Shows the information of each song registered in the app at the moment <br>
     * 
     * @return contents
     */
    public String showContents() {
        String contents = "************* Song **************\n";
        contents += "** Title: " + getTitle() + "\n";
        contents += "** Artist: " + getArtistName() + "\n";
        contents += "** Duration: " + formatLength(getSongLength()) + "\n";
        contents += "** Genre: " + getSongGenre() + "\n";
        contents += "**********************************\n";
        return contents;
    }
}
