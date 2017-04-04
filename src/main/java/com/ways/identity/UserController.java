package com.ways.identity;

import com.ways.identity.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {

  @PostMapping
  public String registerUser(User user) {
    return "beep";
  }
}
