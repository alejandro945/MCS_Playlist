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
        int i = 0;
        for(i = 0; i<MAX_USERS && !userExist && users[i] != null; i++){
            if(userNickName.equals(users[i].getUserNickName()) &&  password.equals(users[i].getPassword())){
              userExist = true;
            }
        }
        return userExist;
    }
    public boolean searchPlaylistUser(String userNickName,Playlist identified){
        boolean userExist = false;
        int i = 0;
        if(identified instanceof Private){
            Private privatePlay = (Private) identified;
            User[] privatePlayUser = privatePlay.getPrivateUsers();
            for(i = 0; i<privatePlayUser.length && !userExist && privatePlayUser[i] != null; i++){
                if(userNickName.equals(privatePlayUser[i].getUserNickName())){
                  userExist = true;
                }
            }
        }if(identified instanceof Restricted){
            Restricted restrcitedPlay = (Restricted) identified;
            User[] restrictedPlayUser = restrcitedPlay.getRestrictedUsers();
            for(i = 0; i<restrictedPlayUser.length && !userExist && restrictedPlayUser[i] != null;i++){
                if(userNickName.equals(restrictedPlayUser[i].getUserNickName())){
                    userExist = true;
                }
            }
        }

        return userExist;
    }

    public String addSong(String title, String artistName, String streamingDate, int songLength, Genre genre,String songOwner,String ownerPassword){
        String msg = "No se pudo agregar la cancion";
        Song newSong = new Song(title,artistName,streamingDate,songLength,genre,songOwner,ownerPassword);
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
   public boolean searchSong(String title){
    boolean songExist = false;
    int i = 0;
    for(i = 0; i<MAX_SONGS && !songExist && poolSongs[i] != null; i++){
        if(title.equals(poolSongs[i].getTitle())){
          songExist = true;
        }
    }
    return songExist;
}
  public String addPlaylist (String playlistName, int playlistType){
    String msg = "No se pudo agregar el playlist";
    Playlist newPublicPlaylist = new Public(playlistName, playlistType);
    Playlist newRestrictedPlaylist = new Restricted(playlistName, playlistType);
    Playlist newPrivatePlaylist = new Private(playlistName, playlistType);
    boolean space = false;
    for(int i = 0; i<MAX_PLAYLIST && !space; i++){
     if(playlists[i] == null && playlistType == 1){
         playlists[i] = newPublicPlaylist;
         space = true;
         msg="Playlist Publico agregado exitosamente";
     }else if(playlists[i] == null && playlistType == 2){
         playlists[i] = newRestrictedPlaylist;
         space = true;
         msg="Playlist Restringido agregado exitosamente";
     }else if(playlists[i] == null && playlistType == 3){
        playlists[i] = newPrivatePlaylist;
        space = true;
        msg="Playlist Privado agregado exitosamente";
    }
    }
    return msg;
  }
  public Playlist searchPlaylist(String playlistName){
      boolean playlistExist = false;
      Playlist identified = null;
      int i = 0;
    for(i = 0; i<MAX_PLAYLIST && !playlistExist && playlists[i] != null; i++){
        if(playlistName.equals(playlists[i].getPlaylistName())){
          identified = playlists[i];
          playlistExist = true;
        }
    }
      return identified;
  }
   public void setUserCategory(){
       int userCountSong =0;
       int render = 1;
       int i = 0;
       for(i=0;i<MAX_USERS && users[i] != null;i++){
           for(int j=0;j<MAX_SONGS && poolSongs[j] != null;j++){
           if(poolSongs[j].getSongOwner().equals(users[i].getUserNickName()) && poolSongs[j].getOwnerPassword().equals(users[i].getPassword())){
               userCountSong ++;
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
           userCountSong = 0;
       }
   }
  
   public String addUserToPlaylist(String userNickName, Playlist identified){
    String msg = "No se pudo agregar el usuario";
    int i = 0;
    for(i =0; i<MAX_USERS && users[i]!=null;i++){
    if(userNickName.equals(users[i].getUserNickName())){
          if(identified instanceof Restricted){
             Restricted restritedPlay = (Restricted) identified;
             boolean agree = restritedPlay.setRestrictedUsers(users[i]);
             if(agree){
             msg = "Se ha agregado exitosamente al playlist restringido el usuario: " + users[i].getUserNickName();
             }
          }else if(identified instanceof Private){
             Private privatePlay = (Private) identified;
             boolean agree = privatePlay.setPrivateUsers(users[i]);
             if(agree){
             msg = "Se ha agregado exitosamente al playlist privado el usuario: " + users[i].getUserNickName(); 
             }
    }
   }
}
    return msg;
}
   public String addSongToPlaylist(String title, Playlist identified){
         String msg = "No se pudo agregar la cancion";
         int i = 0;
         for(i = 0; i<MAX_SONGS && poolSongs[i] != null;i++){
            if(title.equals(poolSongs[i].getTitle())){
                if(identified instanceof Public){
                    Public publicPlay = (Public) identified;
                    publicPlay.setSongList(poolSongs[i]);
                    publicPlay.setLengthToPlaylist();
                    msg = "Se ha agregado exitosamente al playlist publico la cancion: " + poolSongs[i].getTitle();
         }else if(identified instanceof Restricted){
                 Restricted restritedPlay = (Restricted) identified;
                 restritedPlay.setSongList(poolSongs[i]);
                 restritedPlay.setLengthToPlaylist();
                 msg = "Se ha agregado exitosamente al playlist restringido la cancion: " + poolSongs[i].getTitle();
         }else if(identified instanceof Private){
             Private privatePlay = (Private) identified;
             privatePlay.setSongList(poolSongs[i]);
             privatePlay.setLengthToPlaylist();
             msg = "Se ha agregado exitosamente al playlist privado la cancion: " + poolSongs[i].getTitle();
         }
        }
    }
         return msg;
   }
   public String addScores(int scores, Playlist identified){
       String msg = "No se pudo adiccionar tu calificacion";
       if(identified instanceof Public){
        Public publicPlay = (Public) identified;
        publicPlay.setScoresAverages(scores);
        msg = "Se ha agregado exitosamente tu calificacion al playlist: " + publicPlay.getPlaylistName();
        }
       return msg;
   }
   public void setPlaylistLength(){
    int i = 0;
    int playlistLength = 0;
       for(i = 0;i<MAX_PLAYLIST  && playlists[i] != null;i++){
        if(playlists[i] instanceof Public){
            Public publicPlay = (Public) playlists[i];
            playlistLength = publicPlay.setLengthToPlaylist();
            playlists[i].setPlaylistLength(playlistLength);
        }else if(playlists[i] instanceof Restricted){
            Restricted restrictedPlay = (Restricted) playlists[i];
            playlistLength = restrictedPlay.setLengthToPlaylist();
            playlists[i].setPlaylistLength(playlistLength);
        }else if(playlists[i] instanceof Private){
            Private privatePlay = (Private) playlists[i];
            playlistLength = privatePlay.setLengthToPlaylist();
            playlists[i].setPlaylistLength(playlistLength);
        }
       }
   }
   public void setPlaylistGenre(){
    int i = 0;
    Genre[] genre;
       for(i = 0;i<MAX_PLAYLIST  && playlists[i] != null;i++){
        if(playlists[i] instanceof Public){
            Public publicPlay = (Public) playlists[i];
            genre = publicPlay.setGenresToPlaylist();
            playlists[i].setGenres(genre);
        }else if(playlists[i] instanceof Restricted){
            Restricted restrictedPlay = (Restricted) playlists[i];
            genre = restrictedPlay.setGenresToPlaylist();
            playlists[i].setGenres(genre);
        }else if(playlists[i] instanceof Private){
            Private privatePlay = (Private) playlists[i];
            genre = privatePlay.setGenresToPlaylist();
            playlists[i].setGenres(genre);
        }
       }
   }
   public String showUsers(){
       String content = "";
       for(int i = 0 ; i<MAX_USERS;i++){
        if(users[i] != null){
           setUserCategory();
           content += users[i].showContents();
     }
    }
     return content;
   }
   public String showSongs(){
    String content = "";
    for(int i = 0 ; i<MAX_SONGS;i++){
     if(poolSongs[i] != null){
        content += poolSongs[i].showContents();
     }
  }
  return content;
}
public String showPlaylists(){
    String content = "";
    for(int i = 0 ; i<MAX_PLAYLIST;i++){
     if(playlists[i] != null){
        setPlaylistLength();
        setPlaylistGenre();
        content += playlists[i].showInfo();
     }
  }
  return content;
}
public String showGenericPlaylists(){
    String content = "";
    for(int i = 0 ; i<MAX_PLAYLIST;i++){
     if(playlists[i] != null){
        setPlaylistLength();
        setPlaylistGenre();
        content += playlists[i].showContents();
     }
  }
  return content;
}
}
