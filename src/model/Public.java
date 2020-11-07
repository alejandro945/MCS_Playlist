package model;

public class Public extends Playlist {

  private static final int MAX_PUBLIC_SCORES = 10;
  private static final int MAX_SONGS = 30;

  private Song[] songList;
  private int[] scoreAverages;

  /**
   * The constructor method of a Public Playlist Object<br>
   */
  public Public(String playlistName, int playlistType) {
    super(playlistName, playlistType);
    scoreAverages = new int[MAX_PUBLIC_SCORES];
    songList = new Song[MAX_SONGS];
  }

  /**
   * Gets a the song array or the list of song objects previously added <br>
   * 
   * @return songlist
   */
  public Song[] getSongList() {
    return songList;
  }

  /**
   * Sets the songList of this class, this method is use for add or modify a new
   * song in a public playlist identified <br>
   * 
   * @param song Keep in mind that the preconditions of this method have been done
   *             previously <br>
   */
  public void setSongList(Song song) {
    boolean space = false;
    for (int i = 0; i < MAX_SONGS && !space; i++) {
      if (songList[i] == null) {
        this.songList[i] = song;
        space = true;
      }
    }
  }

  /**
   * Gets the array of scores recently added <br>
   * 
   * @return scoreAverages
   */
  public int[] getScoresAverages() {
    return scoreAverages;
  }

  /**
   * Sets the scores of the public playlist, even this method is use for adding
   * <br>
   * 
   * @param scores != String, because it wouldn't make sense
   */
  public void setScoresAverages(int scores) {
    boolean finished = false;
    for (int i = 0; i < MAX_PUBLIC_SCORES && !finished; i++) {
      if (scoreAverages[i] == 0) {
        this.scoreAverages[i] = scores;
        finished = true;
      }
    }
  }

  /**
   * Returns the total duration of the playlist, while modifying it <br>
   * 
   * @return totalLength
   */
  public int setLengthToPlaylist() {
    int totalLength = 0;
    for (int i = 0; i < MAX_SONGS; i++) {
      if (songList[i] != null) {
        totalLength += songList[i].getSongLength();
      }
    }
    return totalLength;
  }

  /**
   * Returns the song genres of the playlist, while modifying them <br>
   * 
   * @return genre
   */
  public Genre[] setGenresToPlaylist() {
    Genre[] genre = new Genre[MAX_SONGS];
    for (int i = 0; i < MAX_SONGS; i++) {
      if (songList[i] != null) {
        genre[i] = songList[i].getSongGenre();
      }
    }
    return genre;
  }

  /**
   * Efficient method since adding the notes or grades added to the playlist at
   * the same time finding the average <br>
   * 
   * @param scoreAverages
   * @return averages
   */
  public double average(int[] scoreAverages) {
    double averages = 0;
    double count = 0;
    double sumScores = 0;
    for (int i = 0; i < scoreAverages.length; i++) {
      if (scoreAverages[i] != 0) {
        sumScores += scoreAverages[i];
        count++;
      }
    }
    averages = (sumScores / count);
    return averages;
  }

  /**
   * Shows the Particular information of each public Playlist registered in the
   * app at the moment <br>
   * 
   * @return contents
   */
  @Override
  public String showInfo() {
    String contents = super.showContents();
    if (scoreAverages != null) {
      contents += "--------------PUBLICO--------------\n**Calificacion Promedio:\n";
      contents += "**Nota Promedio: " + average(scoreAverages) + "\n";
    }
    contents += "**Canciones Agregadas:\n";
    for (int i = 0; i < MAX_SONGS; i++) {
      if (songList[i] != null) {
        contents += "**Cancion " + (i + 1) + " : " + songList[i].getTitle() + "\n";
      }
    }
    return contents;
  }
}
