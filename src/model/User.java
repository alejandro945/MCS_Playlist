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
     
     /** 
      * @return String
      */
     public String getUserNickName(){
          return userNickName;
     }
     
     /** 
      * @param userNickname
      */
     public void setUserNickName(String userNickname){
          this.userNickName = userNickname;
     }
     
     /** 
      * @return String
      */
     public String getPassword(){
          return password;
     }
     
     /** 
      * @param password
      */
     public void setPassword(String password){
          this.password = password;
     }
     
     /** 
      * @return int
      */
     public int getAge(){
          return age;
     }
     
     /** 
      * @param age
      */
     public void setAge(int age){
          this.age = age;
     }
     
     /** 
      * @return UserCategory
      */
     public UserCategory getCategory(){
          return userCategory;
     }
     
     /** 
      * @param category
      */
     public void setCategory(int category){
       if(category==1){
          this.userCategory = UserCategory.NEWBIE; 
       }else if(category==2){
          this.userCategory = UserCategory.LITTLE_CONTRIBUTOR;
       }else if(category==3){
          this.userCategory = UserCategory.MILD_CONTRIBUTOR;    
       }else if(category==4){
          this.userCategory = UserCategory.STAR_CONTRIBUTOR;
       }
     }
     
     /** 
      * @return String
      */
     public String showContents(){
          String contents = "************* User **************\n";
          contents+= "** Username: "+ getUserNickName() + "\n";
          contents+= "** Age: "+ getAge() + "\n";
          contents+= "** Category: "+ getCategory() + "\n";
          contents+= "**********************************\n";
          return contents;
      }

}