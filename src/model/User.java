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
      userCategory = UserCategory.NEWBIE;
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
     public int getCategory(){
          return userCategory;
     }
     public void setCategory(int category){
       if(category==1){
          this.userCategory = userCategory.NEWBIE; 
       }else if(category==2){
          this.userCategory = userCategory.LITTLE_CONTRIBUTOR;
       }else if(category==3){
          this.userCategory = userCategory.MILD_CONTRIBUTOR;    
       }else if(category==4){
          this.userCategory = userCategory.STAR_CONTRIBUTOR;
       }
     }
     public String showContents(){
          String contents = "************* User **************\n";
          contents+= "** Username: "+ getUserNickName() + "\n";
          contents+= "** Age: "+ getAge() + "\n";
          contents+= "** Category: "+ getCategory() + "\n";
          contents+= "**********************************";
          return contents;
      }

}