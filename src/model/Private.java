package model;
public class Private extends Playlist {
    private static final int MAX_PRIVATE_USERS= 1;
    private Song[] songList;
    private User[] privateUsers;

    public Private(String playlistName, int playlistType){
        super(playlistName,playlistType);
        privateUsers = new User[MAX_PRIVATE_USERS];
        songList = new Song[30];
    }
}
