package model;
public class Public extends Playlist {
    private static final int MAX_PUBLIC_SCORES= 10;
    private static final int MAX_SONGS = 30;
    private Song[] songList;
    private int[] scoreAverages;

    public Public(String playlistName, int playlistType){
        super(playlistName,playlistType);
        scoreAverages = new int[MAX_PUBLIC_SCORES];
        songList = new Song[MAX_SONGS];
    }
    
    /** 
     * @return Song[]
     */
    public Song[] getSongList(){
      return songList;
    }
    
    /** 
     * @param song
     */
    public void setSongList(Song song){
      boolean space = false;
      for(int i = 0; i<MAX_SONGS && !space;i++){
        if(songList[i] == null){
          this.songList[i] = song;
          space = true;
          }
        }
    }
  
  /** 
   * @return int[]
   */
  public int[] getScoresAverages(){
    return scoreAverages;
  }
  
  /** 
   * @param scores
   */
  public void setScoresAverages(int scores){
    boolean finished = false;
    for(int i = 0;i<MAX_PUBLIC_SCORES && !finished ;i++){
      if(scoreAverages[i] == 0){
       this.scoreAverages[i] = scores;
       finished = true;
      }
    }
  }
  
  /** 
   * @return int
   */
  public int setLengthToPlaylist(){
    int totalLength = 0;
    for(int i = 0;i<MAX_SONGS; i++){
      if(songList[i] != null){
        totalLength += songList[i].getSongLength();
      }
    }
    return totalLength;
 }
 
 /** 
  * @return Genre[]
  */
 public Genre[] setGenresToPlaylist(){
  Genre[] genre = new Genre[MAX_SONGS];
  for(int i = 0; i<MAX_SONGS;i++){
      if(songList[i] != null){
          genre[i] = songList[i].getSongGenre();
      }
  }
  return genre;
}
  
  /** 
   * @param scoreAverages
   * @return double
   */
  public double average(int[] scoreAverages){
    double averages = 0;
    double count = 0;
    double sumScores = 0;
    for(int i = 0;i<scoreAverages.length;i++){
      if(scoreAverages[i] != 0){
       sumScores += scoreAverages[i];
       count++;
      }
    }
    averages = (sumScores/count);
    return averages;
  }

 
 /** 
  * @return String
  */
 @Override
       public String showInfo(){
          String contents = super.showContents();
          if(scoreAverages!=null){
            contents += "**PUBLICO - CALIFICACION PROMEDIO:\n";
            contents += "**Nota Promedio: " + average(scoreAverages) + "\n";
          }
          contents += "**PUBLICO - Canciones Agregadas:\n";
          for(int i = 0;i<MAX_SONGS;i++){
              if(songList[i] != null){
                  contents+= "**Cancion " + (i+1) + " " +  songList[i].getTitle() + "\n";
              }
          }
          return contents;
       }
}
