package model;
public class Mcs {
    private static final int MAX_USERS = 10;
    private static final int MAX_PLAYLIST = 20;
    private static final int MAX_SONGS = 30;

    private User[] users;
    private Playlist[] playlists;
    private Song[] poolSongs;
  
    public Mcs(){
        users = new User [MAX_USERS];
        poolSongs = new Song [MAX_SONGS];
        playlists = new Playlist[MAX_PLAYLIST];
    } 

    public String addUser(String userNickName,String password, int age){
        String msg = "No se pudo agregar el usuario";
        User newUser = new User(userNickName,password,age);
        boolean space = false;
        for(int i = 0; i<MAX_USERS && !space; i++){
         if(users[i] == null){
             users[i] = newUser;
             space = true;
             msg="Usuario agregado exitosamente";
         }
        }
        return msg;
        }
    public boolean searchUser(String userNickName,String password){
        boolean userExist = false;
        for(int i = 0; i<MAX_USERS;i++){
            if(users[i].getUserNickName == userNickName && users[i].getPassword == password){
              userExist = true;
            }
            return userExist;
        }
    }

    public String addSong(String title, String artistName, String streamingDate, int songLength, Genre genre,String songOwner,String ownwerPassword){
        String msg = "No se pudo agregar la cancion";
        Song newSong = new Song(title,artistName,streamingDate,songLength,genre,songOwner,ownwerPassword);
        boolean space = false;
        for(int i = 0; i<MAX_SONGS && !space ; i++){
         if(poolSongs[i] == null){
             poolSongs[i] = newSong;
             space = true;
             msg="Cancion agregada exitosamente";
         }
        }
        return msg;
   }
       public String calculatePlaylistLength(){
       double sumLength = 0;
        for(int i=0;i<MAX_SONGS;i++){
          sumLength += poolSongs[i].getSongLength; 
        }
        int hours = (int)(sumLength/3600);
        int minutes = (int)((sumLength-hours*3600)/60);
        int seconds = (int)(sumLength-(hours*3600+minutes*60));
        String format = (hours + " horas " + minutes +" minutos " + seconds + " segundos ");
        return format;
      }
   public String addPlaylist(String playlistName){

   }
   public void setUserCategory(){
       int userCountSong =0;
       int render = 1;
       for(int i=0;i<MAX_USERS;i++){
           for(int j=0;j<MAX_SONGS;j++){
           if(poolSongs[j].getSongOwner == users[i].getUserNickName && poolSongs[j].getOwnerPassword == users[i].getPassword){
               userCountSong ++;
           }
           if(userCountSong<3){
               users[i].setCategory(render);
           }else if(userCountSong>=3 && userCountSong < 10){
               render =2;
               users[i].setCategory(render);
           }else if(userCountSong>=10 && userCountSong < 30){
               render =3;
               users[i].setCategory(render);
           }else if(userCountSong>=30){
               render =4;
               users[i].setCategory(render);
           }
           }
       }
   }
   public String showUser(){
       String content="";
   }
}
