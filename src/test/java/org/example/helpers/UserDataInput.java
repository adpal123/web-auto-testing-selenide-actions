package org.example.helpers;

public class UserDataInput {

  public String name;
  public String phone;

  public UserDataInput(String name, String phone) {
    this.name = name;
    this.phone = phone;
  }

  public String getName() {
    return name;
  }

  public String getPhone() {
    return phone;
  }
}
