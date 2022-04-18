package com.example.demo.payload.request;

import java.util.Set;

public class SignupRequest {

    private String userName;

    private String userEmail;

    private String userSurname;

    private String userNickname;

    private String userPhoneNumber;
    
    private Set<String> userRole;
    
    private String userPassword;
  
    public String getUserName() {
        return userName;
    }
 
    public void setUsername(String userName) {
        this.userName = userName;
    }
 
    public String getUserEmail() {
        return userEmail;
    }
 
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserNickname() {
        return userNickname;
    }
 
    public void setUserNickname (String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }
 
    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserSurname() {
        return userSurname;
    }
 
    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }
 
    public String getUserPassword() {
        return userPassword;
    }
 
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    public Set<String> getUserRole() {
      return this.userRole;
    }
    
    public void setUserRole(Set<String> userRole) {
      this.userRole = userRole;
    }
}
