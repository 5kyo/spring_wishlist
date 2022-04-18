package com.example.demo.payload.response;

import java.util.List;

public class JwtResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private Long userId;
    private String userName;
    private String userEmail;
    private List<String> userRoles;
  
    public JwtResponse( String accessToken, 
                        Long userId, 
                        String userName, 
                        String userEmail, 
                        List<String> userRoles) {
      this.accessToken = accessToken;
      this.userId = userId;
      this.userName = userName;
      this.userEmail = userEmail;
      this.userRoles = userRoles;
    }
  
    public String getAccessToken() {
      return accessToken;
    }
  
    public void setAccessToken(String accessToken) {
      this.accessToken = accessToken;
    }
  
    public String getTokenType() {
      return tokenType;
    }
  
    public void setTokenType(String tokenType) {
      this.tokenType = tokenType;
    }
  
    public Long getUserId() {
      return userId;
    }
  
    public void setUserId(Long userId) {
      this.userId = userId;
    }
  
    public String getUserEmail() {
      return userEmail;
    }
  
    public void setUserEmail(String userEmail) {
      this.userEmail = userEmail;
    }
  
    public String getUserName() {
      return userName;
    }
  
    public void setUserName(String userName) {
      this.userName = userName;
    }
  
    public List<String> getUserRoles() {
      return userRoles;
    }
}
