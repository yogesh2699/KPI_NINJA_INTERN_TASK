package com.training.bean;
public class User {


  private String userId;

  private String username;

  private String email;

  private String password;

  private String contact;
  //private int age;

  public User() {
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public User(String userId, String username, String email, String password, String contact) {
    this.userId = userId;
    this.username = username;
    this.email = email;
    this.password = password;
    this.contact = contact;
  }

  @Override
  public String toString() {
    return "User{" +
            "username='" + username + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", contact='" + contact + '\'' +
            '}';
  }
  /*
	 * public int getAge() { return age; }
	 * 
	 * public void setAge(int age) { this.age = age; }
	 */

}