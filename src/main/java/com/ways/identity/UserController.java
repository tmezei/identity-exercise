package com.ways.identity;

import com.ways.identity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController("/user")
public class UserController {

  @Autowired
  private UserRegistry userRegistry;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void registerUser(@RequestBody User user) {
    userRegistry.register(user);
  }

  @GetMapping
  public User getUserDetails(@RequestHeader("Authorization") String token) {
    if (token == null || token.isEmpty()) throw new IllegalStateException("You shall not pass");

    return userRegistry.findByName(token).orElseThrow(IllegalArgumentException::new);
  }
}
