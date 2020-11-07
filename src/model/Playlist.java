package model;

public abstract class Playlist {
    private static final int GENRES = 6;

    private String playlistName;
    private int playlistType;
    private int playlistLength;
    private Genre[] genres;

    public Playlist(String playlistName, int playlistType) {
        this.playlistName = playlistName;
        this.playlistType = playlistType;
        playlistLength = 0;
        genres = new Genre[GENRES];
    }

    /**
     * Gets the playlist Name <br>
     * @return playlistName
     */
    public String getPlaylistName() {
        return playlistName;
    }

    /**
     * Sets the playlist Name <br>
     * @param playlistName != ""
     */
    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    /**
     * Gets the playlist Type <br>
     * @return playlistType
     */
    public int getPlaylistType() {
        return playlistType;
    }

    /**
     * Sets the playlist Type <br>
     * @param playlistType <=1 playlistType <=3
     */
    public void setPlaylistNameType(int playlistType) {
        this.playlistType = playlistType;
    }

    /**
     * Gets the playlist Length <br>
     * @return playlistLength
     */
    public int getPlaylistLength() {
        return playlistLength;
    }

    /**
     * Sets the playlist Length <br>
     * @param playlistLength
     */
    public void setPlaylistLength(int playlistLength) {
        this.playlistLength = playlistLength;
    }

    /**
     * Gets the Genre array <br>
     * @return genres
     */
    public Genre[] getGenres() {
        return genres;
    }

    /**
     * Depending of the quantity of seconds this method allows us to convert these seconds in the pertinent format <br>
     * @param totalLength != String, because it wouldn't make sense
     * @return format
     */
    public String calculatePlaylistLength(int totalLength) {
        int hours = (int) (totalLength / 3600);
        int minutes = (int) ((totalLength - hours * 3600) / 60);
        int seconds = (int) (totalLength - (hours * 3600 + minutes * 60));
        String format = (hours + " horas " + minutes + " minutos " + seconds + " segundos ");
        return format;
    }

    /** 
     * Method that uses a double traversal at the same time to eliminate the repeated genres for display it as required <br>
     * @param genre != null, for better efficiency
     */
    public void setGenres(Genre[] genre) {
        for (int i = 0; i < genre.length; i++) {
            for (int j = 0; j < genre.length; j++) {
                if (genre[i] != null && i != j) {
                    if (genre[i].equals(genre[j])) {
                        genre[j] = null;
                    }
                }
            }
        }
        for (int k = 0; k < GENRES; k++) {
            if (genre[k] != null) {
                this.genres[k] = genre[k];
            }
        }
    }

    /**
     * ABSTRACT METHOD 
     */
    public abstract String showInfo();

    //------------------------------------Method used to save a few lines of code-----------------------------------------
    /**
     * Shows the Generic information of each Playlist registered in the
     * app at the moment <br>
     * @return contents
     */
    public String showContents() {
        String contents = "************* Playlist **************\n";
        contents += "** Title: " + getPlaylistName() + "\n";
        contents += "** Duration: " + calculatePlaylistLength(getPlaylistLength()) + "\n";
        contents += "** Genre: ";
        for (int i = 0; i < GENRES; i++) {
            if (genres[i] != null) {
                contents += genres[i] + ", ";
            }
        }
        contents += "\n" + "**************************************\n";
        return contents;
    }
}
