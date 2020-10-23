package model;
public class User{

     private String userNickName;
     private String password;
     private int age;
     private UserCategory userCategory;

     public User(String userNickname, String password, int age){
      this.userNickName = userNickname;
      this.password = password;
      this.age = age;
      userCategory = UserCategory.NEWBY;
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

}