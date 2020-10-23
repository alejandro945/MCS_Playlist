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

    public String addSong(String title, String artistName, String streamingDate, int songLength, Genre genre,String userNickName,String password){
        String msg = "No se pudo agregar la cancion";
        User newSong = new Song(title,artistName,streamingDate,songLength,genre,use);
        boolean space = false;
        for(int i = 0; i<MAX_SONGS && !space; i++){
         if(poolSongs[i] == null){
             poolSongs[i] = newSong;
             space = true;
             msg="Cancion agregada exitosamente";
         }
        }
        return msg;
   }
   public String calculateAverage(int[]scores){
    double average = 0;
  for(int i=0;i<scores.length;i++){
    average += scores[i]; 
  }
  average = (average/scores.length);
  int hours = (int)(average/3600);
  int minutes = (int)((average-hours*3600)/60);
  int seconds = (int)(average-(hours*3600+minutes*60));
  String format = (hours + " horas " + minutes +" minutos " + seconds + " segundos ");
  return format;
}
   public String addPlaylist(String playlistName){

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
}
