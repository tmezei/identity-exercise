package com.ways.identity.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

  private final String name;
  private final String email;

  @JsonCreator
  public User(@JsonProperty("name") String name,
              @JsonProperty("email") String email) {
    this.name = name;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }
}
