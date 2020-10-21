package model;
public class User{

     private static final int POOL_SONG_SIZE = 30;

     private String userNickName;
     private String password;
     private int age;
     private Category userCategory;
     private Song[] song;

     public User(String userNickname, String password, int age){
      this.userNickName = userNickname;
      this.password = password;
      this.age = age;
      userCategory = Category.NEWBY;
      song = new Song [POOL_SONG_SIZE];
     }
     public String getUserNickName(){
          return userNickName;
     }
     public void setUserNickName(String userNickname){
          this.userNickName = userNickname;
     }
     public String getPassword(){
          return password;
     }
     public void setPassword(String password){
          this.password = password;
     }
     public int getAge(){
          return age;
     }
     public void setAge(int age){
          this.age = age;
     }
     public void setCategory(Category userCategory){
       
     }
     public String addSong(){
          
     }
}