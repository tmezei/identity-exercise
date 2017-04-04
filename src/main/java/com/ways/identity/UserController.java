package com.ways.identity;

import com.ways.identity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController("/user")
public class UserController {

  @Autowired
  private UserRegistry userRegistry;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public void registerUser(@RequestBody User user) {
    userRegistry.register(user);
  }

  @GetMapping
  public Optional<User> getUserDetails(@RequestHeader("Authorization") String token) {
    if (token == null || token.isEmpty()) throw new IllegalStateException("You shall not pass");

    return userRegistry.findByName(token);
  }
}
