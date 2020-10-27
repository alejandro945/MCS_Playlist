package model;
public class Restricted extends Playlist{
    private static final int MAX_RESTRICTED_USERS= 5;
    private Song[] songList;
    private User[] restrictedUsers;

    public Restricted(String playlistName, int playlistType){
        super(playlistName,playlistType);
        restrictedUsers = new User[MAX_RESTRICTED_USERS];
        songList = new Song[30];
    }

}
