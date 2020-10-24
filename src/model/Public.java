package model;
public class Public extends Playlist {
    private static final int MAX_PUBLIC_USERS= 10;

    private User[] publicUsers;

    public Public(String playlistName){
        super(playlistName);
        publicUsers = new User[MAX_PUBLIC_USERS];
    }
}
