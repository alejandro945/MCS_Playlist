package model;
public class Private extends Playlist {
    private static final int MAX_PRIVATE_USERS= 1;
    private static final int MAX_SONGS = 30;
    private Song[] songList;
    private User[] privateUsers;

    public Private(String playlistName, int playlistType){
        super(playlistName,playlistType);
        privateUsers = new User[MAX_PRIVATE_USERS];
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
    public User[] getPrivateUsers(){
        return privateUsers;
    }
    public boolean setPrivateUsers(User restricted){
        boolean space = false;
        for(int i = 0; i<MAX_PRIVATE_USERS && !space;i++){
        if(privateUsers[i] == null){
        this.privateUsers[i] = restricted;
        space = true;
        }
        } 
        return space;
    }
    @Override
    public String showInfo(){
       String contents = super.showContents() ;
       contents += "**- PRIVADO - Usuario con acesso:\n";
       for(int i = 0;i<MAX_PRIVATE_USERS;i++){
           if(privateUsers[i] != null){
               contents += "**Usuario: " + privateUsers[i].getUserNickName() + "\n";
               contents += "**Contraseña: " + privateUsers[i].getPassword() + "\n";
           }
       }
       contents += "**- PRIVADO - Canciones Agregadas:\n";
       for(int i = 0;i<MAX_SONGS;i++){
           if(songList[i] != null){
               contents+= "**Cancion " + (i+1) + " " +  songList[i].getTitle() + "\n";
           }
       }
       return contents;
    }
}
