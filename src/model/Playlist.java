package model;
public  abstract class Playlist {
    private static final int GENRES = 6;

    private String playlistName;
    private int playlistType;
    private int playlistLength;
    private Genre[] genres;
    
    public Playlist(String playlistName, int playlistType){
     this.playlistName = playlistName;
     this.playlistType = playlistType;
     playlistLength = 0;
     genres = new Genre[GENRES];
    }
    
    /** 
     * @return String
     */
    public String getPlaylistName(){
        return playlistName;
    }
    
    /** 
     * @param playlistName
     */
    public void setPlaylistName(String playlistName){
        this.playlistName = playlistName;
    }
    
    /** 
     * @return int
     */
    public int getPlaylistType(){
        return playlistType;
    }
    
    /** 
     * @param playlistType
     */
    public void setPlaylistNameType(int playlistType){
        this.playlistType = playlistType;
    }
    
    /** 
     * @return int
     */
    public int getPlaylistLength(){
        return playlistLength;
    }
    
    /** 
     * @param playlistLength
     */
    public void setPlaylistLength(int playlistLength){
        this.playlistLength = playlistLength;
    }
    
    /** 
     * @return Genre[]
     */
    public Genre[] getGenres(){
        return genres;
    }
    
    /** 
     * @param totalLength
     * @return String
     */
    public String calculatePlaylistLength(int totalLength){
        int hours = (int)(totalLength/3600);
        int minutes = (int)((totalLength-hours*3600)/60);
        int seconds = (int)(totalLength-(hours*3600+minutes*60));
        String format = (hours + " horas " + minutes +" minutos " + seconds + " segundos ");
        return format;
      }
      
      /** 
       * @param genre
       */
      public void setGenres(Genre[] genre){
        for(int i = 0; i<genre.length;i++){
                for(int j = 0; j<genre.length;j++){
                    if(genre[i]!=null && i != j){
                        if (genre[i].equals(genre[j])) {
                            genre[j] = null; 
                        }
                }
              }
            }
        for(int k = 0;k<GENRES;k++){
            if(genre[k] != null){
                this.genres[k] = genre[k]; 
            }
        }
      }
      
      /** 
       * @param showContents(
       * @return String
       */
      public abstract String showInfo();
    
    /** 
     * @return String
     */
    public String showContents(){
        String contents = "************* Playlist **************\n";
        contents+= "** Title: "+ getPlaylistName() + "\n";
        contents+= "** Duration: "+ calculatePlaylistLength(getPlaylistLength())  + "\n";
        contents+= "** Genre: ";
        for(int i= 0;i<GENRES;i++){
            if(genres[i] != null){
            contents+= genres[i] + ", " ;
            }
        }
        contents+= "\n"+"**************************************\n";
        return contents;
    }
}
