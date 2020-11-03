package model;
public class Restricted extends Playlist{
    private static final int MAX_RESTRICTED_USERS= 5;
    private static final int MAX_SONGS = 30;
    private Song[] songList;
    private User[] restrictedUsers;

    public Restricted(String playlistName, int playlistType){
        super(playlistName,playlistType);
        restrictedUsers = new User[MAX_RESTRICTED_USERS];
        songList = new Song[MAX_SONGS];
    }
    public Song[] getSongList(){
        return songList;
    }
    public void setSongList(Song song){
        boolean space = false;
        for(int i = 0; i<MAX_SONGS && !space;i++){
        if(songList[i] == null){
        this.songList[i] = song;
        space = true;
        }
        }
    }
    public int setLengthToPlaylist(){
        int totalLength = 0;
        for(int i = 0;i<MAX_SONGS; i++){
            if(songList[i] != null){
            totalLength += songList[i].getSongLength();
            }
        }
        return totalLength;
     }
     public Genre[] setGenresToPlaylist(){
        Genre[] genre = new Genre[MAX_SONGS];
        for(int i = 0; i<MAX_SONGS;i++){
            if(songList[i] != null){
                genre[i] = songList[i].getSongGenre();
            }
        }
        return genre;
    }
    public User[] getRestrictedUsers(){
        return restrictedUsers;
    }
    public boolean setRestrictedUsers(User restricted){
        boolean space = false;
        for(int i = 0; i<MAX_RESTRICTED_USERS && !space;i++){
        if(restrictedUsers[i]== null){
        this.restrictedUsers[i] = restricted;
        space = true;
        }
        }
        return space;
    }
    @Override
    public String showInfo(){
       String contents = super.showContents();
       contents += "**- RESTRINGIDO - Usuarios con acesso:\n";
       for(int i = 0;i<MAX_RESTRICTED_USERS;i++){
           if(restrictedUsers[i] != null){       
               contents += "**Usuario " + (i+1) +" " + restrictedUsers[i].getUserNickName() + "\n";
               contents += "**Contraseña: " + restrictedUsers[i].getPassword() + "\n";
           }
       }
       contents += "**- RESTRINGIDO - Canciones Agregadas:\n";
       for(int i = 0;i<MAX_SONGS;i++){
           if(songList[i] != null){
               contents+= "**Cancion " + (i+1) + " " +  songList[i].getTitle() + "\n";
           }
       }
       return contents;
    }

}
