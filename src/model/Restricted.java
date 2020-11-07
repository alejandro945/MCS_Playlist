package model;

public class Restricted extends Playlist {
    private static final int MAX_RESTRICTED_USERS = 5;
    private static final int MAX_SONGS = 30;
    private Song[] songList;
    private User[] restrictedUsers;

    /**
     * The constructor method of a Restricted Playlist Object<br>
     */
    public Restricted(String playlistName, int playlistType) {
        super(playlistName, playlistType);
        restrictedUsers = new User[MAX_RESTRICTED_USERS];
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
     * song in a restricted playlist identified <br>
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
     * Gets the restricted user array or the list of user objects previously added
     * <br>
     * 
     * @return restrictedUsers
     */
    public User[] getRestrictedUsers() {
        return restrictedUsers;
    }

    /**
     * Sets the restricted user array or the list of user objects in other words
     * when a new one is added <br>
     * 
     * @param restricted Keep in mind that the preconditions of this method have
     *                   been done previously <br>
     * @return space
     */
    public boolean setRestrictedUsers(User restricted) {
        boolean space = false;
        for (int i = 0; i < MAX_RESTRICTED_USERS && !space; i++) {
            if (restrictedUsers[i] == null) {
                this.restrictedUsers[i] = restricted;
                space = true;
            }
        }
        return space;
    }

    /**
     * Shows the Particular information of each restricted Playlist registered in
     * the app at the moment <br>
     * 
     * @return contents
     */
    @Override
    public String showInfo() {
        String contents = super.showContents();
        contents += "------------RESTRINGIDO------------\n**Usuarios con acesso:\n";
        for (int i = 0; i < MAX_RESTRICTED_USERS; i++) {
            if (restrictedUsers[i] != null) {
                contents += "**Usuario " + (i + 1) + " : " + restrictedUsers[i].getUserNickName() + "\n";
                contents += "**Contrasena: " + restrictedUsers[i].getPassword() + "\n";
            }
        }
        contents += "**Canciones Agregadas:\n";
        for (int i = 0; i < MAX_SONGS; i++) {
            if (songList[i] != null) {
                contents += "**Cancion " + (i + 1) + " " + songList[i].getTitle() + "\n";
            }
        }
        return contents;
    }

}
