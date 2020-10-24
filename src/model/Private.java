package model;
public class Private extends Playlist {
    private static final int MAX_PRIVATE_USERS= 1;

    private User[] privateUsers;

    public Private(String playlistName){
        super(playlistName);
        privateUsers = new User[MAX_PRIVATE_USERS];
    }
}
