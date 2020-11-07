package model;

public class User {

     private String userNickName;
     private String password;
     private int age;
     private UserCategory userCategory;

     /**
      * The constructor method of a user Object<br>
      */
     public User(String userNickname, String password, int age) {
          this.userNickName = userNickname;
          this.password = password;
          this.age = age;
          userCategory = UserCategory.NEWBIE;
     }

     /**
      * Gets the userNickName <br>
      * 
      * @return userNickName
      */
     public String getUserNickName() {
          return userNickName;
     }

     /**
      * Sets the userNickName <br>
      * 
      * @param userNickname
      */
     public void setUserNickName(String userNickname) {
          this.userNickName = userNickname;
     }

     /**
      * Gets the user password <br>
      * 
      * @return password
      */
     public String getPassword() {
          return password;
     }

     /**
      * Sets the user password <br>
      * 
      * @param password
      */
     public void setPassword(String password) {
          this.password = password;
     }

     /**
      * Gets the age of the user <br>
      * 
      * @return age
      */
     public int getAge() {
          return age;
     }

     /**
      * Sets the user age <br>
      * 
      * @param age age !=String, because it wouldn't make sense
      */
     public void setAge(int age) {
          this.age = age;
     }

     /**
      * Gets the user category <br>
      * 
      * @return userCategory
      */
     public UserCategory getCategory() {
          return userCategory;
     }

     /**
      * Sets the user category <br>
      * 
      * @param category 1<= category <=4
      */
     public void setCategory(int category) {
          if (category == 1) {
               this.userCategory = UserCategory.NEWBIE;
          } else if (category == 2) {
               this.userCategory = UserCategory.LITTLE_CONTRIBUTOR;
          } else if (category == 3) {
               this.userCategory = UserCategory.MILD_CONTRIBUTOR;
          } else if (category == 4) {
               this.userCategory = UserCategory.STAR_CONTRIBUTOR;
          }
     }

     /**
      * Shows the information of each user registered in the app at the moment <br>
      * 
      * @return contents
      */
     public String showContents() {
          String contents = "************* User **************\n";
          contents += "** Username: " + getUserNickName() + "\n";
          contents += "** Age: " + getAge() + "\n";
          contents += "** Category: " + getCategory() + "\n";
          contents += "**********************************\n";
          return contents;
     }

}