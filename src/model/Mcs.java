package model;

public class Mcs {
    private static final int MAX_USERS = 10;
    private static final int MAX_PLAYLIST = 20;
    private static final int MAX_SONGS = 30;

    private User[] users;
    private Playlist[] playlists;
    private Song[] poolSongs;

    /**
     * The constructor method of the mcs Object<br>
     */
    public Mcs() {
        users = new User[MAX_USERS];
        poolSongs = new Song[MAX_SONGS];
        playlists = new Playlist[MAX_PLAYLIST];
    }

    /**
     * Allows you to create or add a user in our application <br>
     * <b> pre: </b> <br>
     * <b> post: </b> It will send a confirmation String or in some cases an error
     * message depending on the number of objects or users that exist in the array
     * <br>
     * 
     * @param userNickName Word that must not contain spaces
     * @param password     As a contract I would say that it should not contain more
     *                     than eight characters.
     * @param age          Positive integer number which is != String
     * @return msg
     */
    public String addUser(String userNickName, String password, int age) {
        String msg = "No se pudo agregar el usuario";
        User newUser = new User(userNickName, password, age);
        boolean space = false;
        for (int i = 0; i < MAX_USERS && !space; i++) {
            if (users[i] == null) {
                users[i] = newUser;
                space = true;
                msg = "Usuario agregado exitosamente";
            }
        }
        return msg;
    }

    /**
     * It will search within the array, for a user with the same nickname and
     * password in each existing position <br>
     * <b> pre: </b> <br>
     * <b> post: </b>It will return a boolean which will be used to grant access if
     * it is the case <br>
     * 
     * @param userNickName can not have spaces or it could be just a word
     * @param password     As a contract I would say that it should not contain more
     *                     than eight characters.
     * @return userExist
     */
    public boolean searchUser(String userNickName, String password) {
        boolean userExist = false;
        int i = 0;
        for (i = 0; i < MAX_USERS && !userExist && users[i] != null; i++) {
            if (userNickName.equals(users[i].getUserNickName()) && password.equals(users[i].getPassword())) {
                userExist = true;
            }
        }
        return userExist;
    }

    /**
     * It will search within the users array for each playlist a user with access
     * and same nickname in each existing position <br>
     * <b> pre: </b> <br>
     * <b> post: </b>It will return a boolean which will be used to grant access if
     * it is the case <br>
     * 
     * @param userNickName Keep in mind that the preconditions of this method have
     *                     been done previously <br>
     * @param identified   != null for better operation
     * @return userExist
     */
    public boolean searchPlaylistUser(String userNickName, Playlist identified) {
        boolean userExist = false;
        int i = 0;
        if (identified instanceof Private) {
            Private privatePlay = (Private) identified;
            User[] privatePlayUser = privatePlay.getPrivateUsers();
            for (i = 0; i < privatePlayUser.length && !userExist && privatePlayUser[i] != null; i++) {
                if (userNickName.equals(privatePlayUser[i].getUserNickName())) {
                    userExist = true;
                }
            }
        }
        if (identified instanceof Restricted) {
            Restricted restrcitedPlay = (Restricted) identified;
            User[] restrictedPlayUser = restrcitedPlay.getRestrictedUsers();
            for (i = 0; i < restrictedPlayUser.length && !userExist && restrictedPlayUser[i] != null; i++) {
                if (userNickName.equals(restrictedPlayUser[i].getUserNickName())) {
                    userExist = true;
                }
            }
        }

        return userExist;
    }

    /**
     * Allows you to create or add a song in our application <br>
     * <b> pre: </b> <br>
     * <b> post: </b> It will send a confirmation String or in some cases an error
     * message depending on the number of objects or songs that exist in the array
     * <br>
     * 
     * @param title         != "", because it wouldn't make sense
     * @param artistName    != "", because it wouldn't make sense
     * @param streamingDate != "", because it wouldn't make sense
     * @param songLength    Positive integer number which is != 0 and String
     * @param genre         type Genre and != null
     * @param songOwner     != "", because it wouldn't make sense
     * @param ownerPassword != "", because it wouldn't make sense
     * @return msg
     */
    public String addSong(String title, String artistName, String streamingDate, int songLength, Genre genre,
            String songOwner, String ownerPassword) {
        String msg = "No se pudo agregar la cancion";
        Song newSong = new Song(title, artistName, streamingDate, songLength, genre, songOwner, ownerPassword);
        boolean space = false;
        for (int i = 0; i < MAX_SONGS && !space; i++) {
            if (poolSongs[i] == null) {
                poolSongs[i] = newSong;
                space = true;
                msg = "Cancion agregada exitosamente";
            }
        }
        return msg;
    }

    /**
     * It will search within the array, for a song with the same title in each
     * existing position <br>
     * <b> pre: </b> <br>
     * <b> post: </b>It will return a boolean which will be used to grant access if
     * it is the case <br>
     * 
     * @param title != "", because it wouldn't make sense
     * @return songExist
     */
    public boolean searchSong(String title) {
        boolean songExist = false;
        int i = 0;
        for (i = 0; i < MAX_SONGS && !songExist && poolSongs[i] != null; i++) {
            if (title.equals(poolSongs[i].getTitle())) {
                songExist = true;
            }
        }
        return songExist;
    }

    /**
     * Allows you to create or add a playlist in our application <br>
     * <b> pre: </b> <br>
     * <b> post: </b> It will send a confirmation String or in some cases an error
     * message depending on the number of objects or playlist that exist in the
     * array <br>
     * 
     * @param playlistName != "", because it wouldn't make sense
     * @param playlistType diferent to String and 1 less than or equal
     *                     toplaylistType less than or equal to 3
     * @return msg
     */
    public String addPlaylist(String playlistName, int playlistType) {
        String msg = "No se pudo agregar el playlist";
        Playlist newPublicPlaylist = new Public(playlistName, playlistType);
        Playlist newRestrictedPlaylist = new Restricted(playlistName, playlistType);
        Playlist newPrivatePlaylist = new Private(playlistName, playlistType);
        boolean space = false;
        for (int i = 0; i < MAX_PLAYLIST && !space; i++) {
            if (playlists[i] == null && playlistType == 1) {
                playlists[i] = newPublicPlaylist;
                space = true;
                msg = "Playlist Publico agregado exitosamente";
            } else if (playlists[i] == null && playlistType == 2) {
                playlists[i] = newRestrictedPlaylist;
                space = true;
                msg = "Playlist Restringido agregado exitosamente";
            } else if (playlists[i] == null && playlistType == 3) {
                playlists[i] = newPrivatePlaylist;
                space = true;
                msg = "Playlist Privado agregado exitosamente";
            }
        }
        return msg;
    }

    /**
     * It will search within the array, for a playlist with the same name netered by
     * console in each existing position <br>
     * <b> pre: </b> <br>
     * <b> post: </b>It will return a playlist object to identify and use this
     * object later <br>
     * 
     * @param playlistName != "", because it wouldn't make sense
     * @return identified
     */
    public Playlist searchPlaylist(String playlistName) {
        boolean playlistExist = false;
        Playlist identified = null;
        int i = 0;
        for (i = 0; i < MAX_PLAYLIST && !playlistExist && playlists[i] != null; i++) {
            if (playlistName.equals(playlists[i].getPlaylistName())) {
                identified = playlists[i];
                playlistExist = true;
            }
        }
        return identified;
    }

    /**
     * Updates in real time the user category or when the method is called depending
     * on the number of songs associated with it <br>
     * <b> pre: </b> <br>
     * <b> post: </b> As mentioned before it will set the category of the user,
     * fulfilling with the functional requirement <br>
     */
    public void setUserCategory() {
        int userCountSong = 0;
        int render = 1;
        int i = 0;
        for (i = 0; i < MAX_USERS && users[i] != null; i++) {
            for (int j = 0; j < MAX_SONGS && poolSongs[j] != null; j++) {
                if (poolSongs[j].getSongOwner().equals(users[i].getUserNickName())
                        && poolSongs[j].getOwnerPassword().equals(users[i].getPassword())) {
                    userCountSong++;
                    if (userCountSong < 3) {
                        users[i].setCategory(render);
                    } else if (userCountSong >= 3 && userCountSong < 10) {
                        render = 2;
                        users[i].setCategory(render);
                    } else if (userCountSong >= 10 && userCountSong < 30) {
                        render = 3;
                        users[i].setCategory(render);
                    } else if (userCountSong >= 30) {
                        render = 4;
                        users[i].setCategory(render);
                    }
                }
            }
            userCountSong = 0;
        }
    }

    /**
     * Provides access to a user in a playlist identified <br>
     * <b> pre: </b> <br>
     * <b> post: </b> It will add a user in the specific array of the playlist
     * identified <br>
     * 
     * @param userNickName != "", because it wouldn't make sense
     * @param identified   !=null for better operation
     * @return msg
     */
    public String addUserToPlaylist(String userNickName, Playlist identified) {
        String msg = "No se pudo agregar el usuario";
        int i = 0;
        for (i = 0; i < MAX_USERS && users[i] != null; i++) {
            if (userNickName.equals(users[i].getUserNickName())) {
                if (identified instanceof Restricted) {
                    Restricted restritedPlay = (Restricted) identified;
                    boolean agree = restritedPlay.setRestrictedUsers(users[i]);
                    if (agree) {
                        msg = "Se ha agregado exitosamente al playlist restringido el usuario: "
                                + users[i].getUserNickName();
                    }
                } else if (identified instanceof Private) {
                    Private privatePlay = (Private) identified;
                    boolean agree = privatePlay.setPrivateUsers(users[i]);
                    if (agree) {
                        msg = "Se ha agregado exitosamente al playlist privado el usuario: "
                                + users[i].getUserNickName();
                    }
                }
            }
        }
        return msg;
    }

    /**
     * Add a song in the previously playlist identified <br>
     * <b> pre: </b> <br>
     * <b> post: </b> It will add a song in the specific array of the playlist
     * identified <br>
     * 
     * @param title      != "", because it wouldn't make sense
     * @param identified != null
     * @return msg
     */
    public String addSongToPlaylist(String title, Playlist identified) {
        String msg = "No se pudo agregar la cancion";
        int i = 0;
        for (i = 0; i < MAX_SONGS && poolSongs[i] != null; i++) {
            if (title.equals(poolSongs[i].getTitle())) {
                if (identified instanceof Public) {
                    Public publicPlay = (Public) identified;
                    publicPlay.setSongList(poolSongs[i]);
                    publicPlay.setLengthToPlaylist();
                    msg = "Se ha agregado exitosamente al playlist publico la cancion: " + poolSongs[i].getTitle();
                } else if (identified instanceof Restricted) {
                    Restricted restritedPlay = (Restricted) identified;
                    restritedPlay.setSongList(poolSongs[i]);
                    restritedPlay.setLengthToPlaylist();
                    msg = "Se ha agregado exitosamente al playlist restringido la cancion: " + poolSongs[i].getTitle();
                } else if (identified instanceof Private) {
                    Private privatePlay = (Private) identified;
                    privatePlay.setSongList(poolSongs[i]);
                    privatePlay.setLengthToPlaylist();
                    msg = "Se ha agregado exitosamente al playlist privado la cancion: " + poolSongs[i].getTitle();
                }
            }
        }
        return msg;
    }

    /**
     * Add a note or rating to a public playlist <br>
     * <b> pre: </b> 1 less than or equal to scores less than or equal to 5.Futher
     * even if we have implemented an error message, it is better to write the name
     * of the playlist correctly for correct operation <br>
     * <b> post: </b> It will add a rating for a particular public playlist and will
     * return a String message indicating the status of the request <br>
     * 
     * @param scores     1 less than or equal to scores less than or equal to 5
     * @param identified != null
     * @return msg
     */
    public String addScores(int scores, Playlist identified) {
        String msg = "No se pudo adiccionar tu calificacion";
        if (identified instanceof Public) {
            Public publicPlay = (Public) identified;
            publicPlay.setScoresAverages(scores);
            msg = "Se ha agregado exitosamente tu calificacion al playlist: " + publicPlay.getPlaylistName();
        }
        return msg;
    }

    /**
     * Updates in real time the playlist length or when the method is called
     * depending on the number of songs associated with it <br>
     * <b> pre: </b> <br>
     * <b> post: </b> As mentioned before it will set the length of the playlists,
     * fulfilling with the functional requirement <br>
     */
    public void setPlaylistLength() {
        int i = 0;
        int playlistLength = 0;
        for (i = 0; i < MAX_PLAYLIST && playlists[i] != null; i++) {
            if (playlists[i] instanceof Public) {
                Public publicPlay = (Public) playlists[i];
                playlistLength = publicPlay.setLengthToPlaylist();
                playlists[i].setPlaylistLength(playlistLength);
            } else if (playlists[i] instanceof Restricted) {
                Restricted restrictedPlay = (Restricted) playlists[i];
                playlistLength = restrictedPlay.setLengthToPlaylist();
                playlists[i].setPlaylistLength(playlistLength);
            } else if (playlists[i] instanceof Private) {
                Private privatePlay = (Private) playlists[i];
                playlistLength = privatePlay.setLengthToPlaylist();
                playlists[i].setPlaylistLength(playlistLength);
            }
        }
    }
    /**
     * Updates in real time the playlist genres or when the method is called
     * depending on the not repeated genres associated with it <br>
     * <b> pre: </b> <br>
     * <b> post: </b> As mentioned before it will set the genres of the playlists,
     * fulfilling with the functional requirement <br>
     */
    public void setPlaylistGenre() {
        int i = 0;
        Genre[] genre;
        for (i = 0; i < MAX_PLAYLIST && playlists[i] != null; i++) {
            if (playlists[i] instanceof Public) {
                Public publicPlay = (Public) playlists[i];
                genre = publicPlay.setGenresToPlaylist();
                playlists[i].setGenres(genre);
            } else if (playlists[i] instanceof Restricted) {
                Restricted restrictedPlay = (Restricted) playlists[i];
                genre = restrictedPlay.setGenresToPlaylist();
                playlists[i].setGenres(genre);
            } else if (playlists[i] instanceof Private) {
                Private privatePlay = (Private) playlists[i];
                genre = privatePlay.setGenresToPlaylist();
                playlists[i].setGenres(genre);
            }
        }
    }

    /**
     * Shows the information of each user registered in the app at the moment <br>
     * 
     * @return content
     */
    public String showUsers() {
        String content = "";
        for (int i = 0; i < MAX_USERS; i++) {
            if (users[i] != null) {
                setUserCategory();
                content += users[i].showContents();
            }
        }
        return content;
    }

    /**
     * Shows the information of each song registered in the app at the moment <br>
     * 
     * @return content
     */
    public String showSongs() {
        String content = "";
        for (int i = 0; i < MAX_SONGS; i++) {
            if (poolSongs[i] != null) {
                content += poolSongs[i].showContents();
            }
        }
        return content;
    }

    /**
     * Shows the Particular information of each Playlist registered in the app at
     * the moment in other words specific data of public, private and restricted
     * playlists <br>
     * 
     * @return content
     */
    public String showPlaylists() {
        String content = "";
        for (int i = 0; i < MAX_PLAYLIST; i++) {
            if (playlists[i] != null) {
                setPlaylistLength();
                setPlaylistGenre();
                content += playlists[i].showInfo();
            }
        }
        return content;
    }

    /**
     * Shows the Generic information of each Playlist registered in the app at the
     * moment <br>
     * 
     * @return content
     */
    public String showGenericPlaylists() {
        String content = "";
        for (int i = 0; i < MAX_PLAYLIST; i++) {
            if (playlists[i] != null) {
                setPlaylistLength();
                setPlaylistGenre();
                content += playlists[i].showContents();
            }
        }
        return content;
    }
}
