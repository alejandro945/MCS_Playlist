package model;

public class Private extends Playlist {
    private static final int MAX_PRIVATE_USERS = 1;
    private static final int MAX_SONGS = 30;

    private Song[] songList;
    private User[] privateUsers;

    /**
     * The constructor method of a Private Playlist Object<br>
     */
    public Private(String playlistName, int playlistType) {
        super(playlistName, playlistType);
        privateUsers = new User[MAX_PRIVATE_USERS];
        songList = new Song[MAX_SONGS];
    }

    /**
     * Gets a the song array or the list of song objects previously added <br>
     * 
     * @return songlist
     */
    public Song[] getSongList() {
        return songList;
    }

    /**
     * Sets the songList of this class, this method is use for add or modify a new
     * song in a privated playlist identified <br>
     * 
     * @param song Keep in mind that the preconditions of this method have been done
     *             previously <br>
     */
    public void setSongList(Song song) {
        boolean space = false;
        for (int i = 0; i < MAX_SONGS && !space; i++) {
            if (songList[i] == null) {
                this.songList[i] = song;
                space = true;
            }
        }
    }

    /**
     * Returns the total duration of the playlist, while modifying it <br>
     * 
     * @return totalLength
     */
    public int setLengthToPlaylist() {
        int totalLength = 0;
        for (int i = 0; i < MAX_SONGS; i++) {
            if (songList[i] != null) {
                totalLength += songList[i].getSongLength();
            }
        }
        return totalLength;
    }

    /**
     * Returns the song genres of the playlist, while modifying them <br>
     * 
     * @return genre
     */
    public Genre[] setGenresToPlaylist() {
        Genre[] genre = new Genre[MAX_SONGS];
        for (int i = 0; i < MAX_SONGS; i++) {
            if (songList[i] != null) {
                genre[i] = songList[i].getSongGenre();
            }
        }
        return genre;
    }

    /**
     * Gets the privated user array or the list of user objects previously added
     * <br>
     * 
     * @return privateUsers
     */
    public User[] getPrivateUsers() {
        return privateUsers;
    }

    /**
     * Sets the privated user array or the list of user objects in other words
     * when a new one is added <br>
     * 
     * @param privated Keep in mind that the preconditions of this method have
     *                   been done previously <br>
     * @return space
     */
    public boolean setPrivateUsers(User privated) {
        boolean space = false;
        for (int i = 0; i < MAX_PRIVATE_USERS && !space; i++) {
            if (privateUsers[i] == null) {
                this.privateUsers[i] = privated;
                space = true;
            }
        }
        return space;
    }

    /**
     * Shows the Particular information of each private Playlist registered in the
     * app at the moment <br>
     * 
     * @return contents
     */
    @Override
    public String showInfo() {
        String contents = super.showContents();
        contents += "-----------PRIVADO----------\n**Usuario con acesso:\n";
        for (int i = 0; i < MAX_PRIVATE_USERS; i++) {
            if (privateUsers[i] != null) {
                contents += "**Usuario: " + privateUsers[i].getUserNickName() + "\n";
                contents += "**Contrasena: " + privateUsers[i].getPassword() + "\n";
            }
        }
        contents += "**Canciones Agregadas:\n";
        for (int i = 0; i < MAX_SONGS; i++) {
            if (songList[i] != null) {
                contents += "**Cancion " + (i + 1) + " : " + songList[i].getTitle() + "\n";
            }
        }
        return contents;
    }
}
