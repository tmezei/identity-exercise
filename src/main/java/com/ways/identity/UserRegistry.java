package com.ways.identity;

import com.ways.identity.model.User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserRegistry {

  private final Set<User> users = new HashSet<>();

  public void register(User user) {
    users.add(user);
  }

  public Optional<User> findByName(String name) {
    return users.stream().filter(u -> u.getName().equals(name)).findFirst();
  }
}
