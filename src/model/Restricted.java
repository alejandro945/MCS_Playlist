package model;
public class Restricted extends Playlist{
    private static final int MAX_RESTRICTED_USERS= 5;

    private User[] restrictedUsers;

    public Restricted(String playlistName){
        super(playlistName);
        restrictedUsers = new User[MAX_RESTRICTED_USERS];
    }
}
