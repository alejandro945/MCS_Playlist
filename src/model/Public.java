package model;
public class Public extends Playlist {
    private static final int MAX_PUBLIC_SCORES= 10;
    private Song[] songList;
    private int[] scoreAverages;

    public Public(String playlistName, int playlistType){
        super(playlistName,playlistType);
        scoreAverages = new int[MAX_PUBLIC_SCORES];
        songList = new Song[30];
    }
   /* public String calculatePlaylistLength(){
        int sumLength = 0;
         for(int i=0;i<MAX_SONGS;i++){
           sumLength += poolSongs[i].getSongLength(); 
         }
         int hours = (int)(sumLength/3600);
         int minutes = (int)((sumLength-hours*3600)/60);
         int seconds = (int)(sumLength-(hours*3600+minutes*60));
         String format = (hours + " horas " + minutes +" minutos " + seconds + " segundos ");
         return format;
       }*/
}
